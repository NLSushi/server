package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    //commit 왜 안되니
    //모든 기사 조회
    @GetMapping(value="api/article")
    public Result viewAllArticle(){
        List<ArticleOutput> response = articleService.showArticles();
        return new Result(response);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }
}
