package ewha.nlsushi.newsum.api;


import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;
    private final Environment env;

    //profile 조회
    @GetMapping(value="/profile")
    public String getProfile(){
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
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

    @GetMapping(value="test")
    public Result test(){
        List<ArticleOutput> response = articleService.showRecent();
        return new Result(response);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }
}
