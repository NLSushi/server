package ewha.nlsushi.newsum.api;


import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.api.response.ArticleResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    @GetMapping(value="api/article")
    @ApiOperation(value="모든 기사 조회",notes="전체 기사문을 조회합니다.")
    public Result viewAllArticle(){
        List<ArticleResponse> response = articleService.showArticles();
        return new Result(response);
    }

    @GetMapping(value="api/joongang/recent")
    @ApiOperation(value="중앙일보 최신 기사 조회",notes="중앙일보 최신 기사를 조회합니다.")
    public Result viewJoongangRecent(){
        List<ArticleResponse> response = articleService.showJoongangRecent();
        return new Result(response);
    }
    @GetMapping(value="api/khan/recent")
    @ApiOperation(value="경향신문 최신 기사 조회",notes="경향신문 최신 기사를 조회합니다.")
    public Result viewKhanRecent(){
        List<ArticleResponse> response = articleService.showKhanRecent();
        return new Result(response);
    }
    @GetMapping(value="api/han/recent")
    @ApiOperation(value="한겨레 최신 기사 조회",notes="한겨레 최신 기사를 조회합니다.")
    public Result viewHanRecent(){
        List<ArticleResponse> response = articleService.showHanRecent();
        return new Result(response);
    }

    @GetMapping(value="api/recent")
    @ApiOperation(value="최신 기사 조회",notes="최신 기사를 조회합니다.")
    public Result viewRecent(){
        List<ArticleResponse> response = articleService.showRecent();
        return new Result(response);
    }

    @GetMapping(value="api/search")
    @ApiOperation(value="해시태그로 기사 조회",notes="hashtag 파라미터로 들어온 값을 해시태그로 달고 있는 기사들을 조회합니다.")
    @ApiImplicitParam(name="hashtag", value="조회할 기사의 해시태그", required = true)
    public Result searchArticleByHashTag(@RequestParam("hashtag")String hashtag){
        List<ArticleResponse> response = articleService.SearchArticlesByHashTag(hashtag);
        return new Result(response);
    }

}
