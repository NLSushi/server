package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.repository.ArticleRepositorySupport;
import ewha.nlsushi.newsum.repository.MemberRepository;
import ewha.nlsushi.newsum.repository.ScrapArticleRepository;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScrapArticleService {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final ScrapArticleRepository scrapArticleRepository;
    private final ArticleService articleService;

    @Transactional
    public ScrapArticle scrapArticle(String userId, Long articlePK){
        Member member = memberRepository.findByUserId(userId);
        Article article = articleRepository.getById(articlePK);
        ScrapArticle scrapArticle = new ScrapArticle(member, article);
        return scrapArticleRepository.save(scrapArticle);
    }

    @Transactional
    public void UnScrapArticle(Long scrapArticlePK){
        ScrapArticle target = scrapArticleRepository.getById(scrapArticlePK);
        target.getScrap_article().getScrap_articles().remove(target);
        target.getScrap_member().getScrap_articles().remove(target);
        scrapArticleRepository.delete(target);
    }

    public List<ArticleOutput> showScrapArticle(String userId){
        Member member = memberRepository.findByUserId(userId);
        List<ScrapArticle> scrapArticles = member.getScrap_articles();
        List<Article> articles = new ArrayList<>();
        for(ScrapArticle each: scrapArticles)
            articles.add(each.getScrap_article());
        return articleService.articleListToDTOList(articles);
    }
}
