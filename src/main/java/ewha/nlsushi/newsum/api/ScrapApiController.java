package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.api.DTO.ScrapRequest;
import ewha.nlsushi.newsum.api.DTO.UnScrapRequest;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.service.ScrapArticleService;
import ewha.nlsushi.newsum.api.response.ArticleResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ScrapApiController {

    private final ScrapArticleService scrapArticleService;

    @PostMapping("api/scrap")
    @ApiOperation(value="기사 스크랩",notes="유저 아이디와 스크랩할 기사 id를 받아 해당 기사를 스크랩합니다.")
    public ScrapArticle scrapArticle(@RequestBody @Valid ScrapRequest scrapRequest) {
        return scrapArticleService.scrapArticle(scrapRequest.getUserId(), scrapRequest.getArticleId());
    }

    @GetMapping("api/scrap/view")
    @ApiOperation(value="유저별 스크랩 기사 조회",notes="userId 파라미터로 받은 유저가 스크랩한 기사들을 조회합니다.")
    @ApiImplicitParam(name="userId",value="조회할 유저 아이디",required = true)
    public Result showScrapArticle(@RequestParam("userId") String userId) {
        List<ArticleResponse> response = scrapArticleService.showScrapArticle(userId);
        return new Result(response);
    }

    @DeleteMapping("api/unscrap")
    @ApiOperation(value="스크랩 취소",notes="유저 아이디와 스크랩을 취소할 기사 id를 받아 해당 기사의 스크랩을 취소합니다.")
    public boolean unScrapArticle(@RequestBody @Valid UnScrapRequest request) {
        scrapArticleService.unScrapArticle(request.getUserId(), request.getArticleId());
        return true;
    }
}
