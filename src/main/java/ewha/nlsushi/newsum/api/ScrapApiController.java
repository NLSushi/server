package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.service.ScrapArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ScrapApiController {

    private final ScrapArticleService scrapArticleService;

    @PostMapping("api/scrap/{userId}/{articlePK}")
    public ScrapArticle scrapArticle(@PathVariable("userId") String userId,
                                     @PathVariable("articlePK") Long articlePK) {
        return scrapArticleService.scrapArticle(userId, articlePK);
    }

    @GetMapping("api/scrap/view/{userId}")
    public ArticleApiController.Result showScrapArticle(@PathVariable("userId") String userId) {
        List<ArticleOutput> response = scrapArticleService.showScrapArticle(userId);
        return new ArticleApiController.Result(response);
    }

    @DeleteMapping("api/unscrap/{scrapPK}")
    public void unScrapArticle(@PathVariable("scrapPK") Long scrapPK) {
        scrapArticleService.UnScrapArticle(scrapPK);
    }
}
