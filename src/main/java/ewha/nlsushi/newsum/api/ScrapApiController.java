package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.api.requestform.ScrapRequest;
import ewha.nlsushi.newsum.api.requestform.UnScrapRequest;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.service.ScrapArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
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
    public ScrapArticle scrapArticle(@RequestBody @Valid ScrapRequest scrapRequest) {
        return scrapArticleService.scrapArticle(scrapRequest.getUserId(), scrapRequest.getArticleId());
    }

    @GetMapping("api/scrap/view")
    public ArticleApiController.Result showScrapArticle(@RequestParam("userId") String userId) {
        List<ArticleOutput> response = scrapArticleService.showScrapArticle(userId);
        return new ArticleApiController.Result(response);
    }

    @DeleteMapping("api/unscrap")
    public boolean unScrapArticle(@RequestBody @Valid UnScrapRequest request) {
        scrapArticleService.unScrapArticle(request.getUserId(), request.getArticleId());
        return true;
    }
}
