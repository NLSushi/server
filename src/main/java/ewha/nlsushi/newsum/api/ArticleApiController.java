package ewha.nlsushi.newsum.api;


import ewha.nlsushi.newsum.api.requestform.SearchRequest;
import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    //모든 기사 조회
    @GetMapping(value="api/article")
    public Result viewAllArticle(){
        List<ArticleOutput> response = articleService.showArticles();
        return new Result(response);
    }

    @GetMapping(value="api/joongang/recent")
    public Result viewJoongangRecent(){
        List<ArticleOutput> response = articleService.showJoongangRecent();
        return new Result(response);
    }
    @GetMapping(value="api/khan/recent")
    public Result viewKhanRecent(){
        List<ArticleOutput> response = articleService.showKhanRecent();
        return new Result(response);
    }
    @GetMapping(value="api/han/recent")
    public Result viewHanRecent(){
        List<ArticleOutput> response = articleService.showHanRecent();
        return new Result(response);
    }

    @GetMapping(value="api/recent")
    public Result viewRecent(){
        List<ArticleOutput> response = articleService.showRecent();
        return new Result(response);
    }

    @GetMapping(value="api/search")
    public Result searchArticleByHashTag(@RequestParam("hashtag")String hashtag){
        List<ArticleOutput> response = articleService.SearchArticlesByHashTag(hashtag);
        return new Result(response);
    }


    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }
}
