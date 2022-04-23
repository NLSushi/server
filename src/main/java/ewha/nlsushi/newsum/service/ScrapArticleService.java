package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.exception.ExceptionEnum;
import ewha.nlsushi.newsum.exception.UnScrapUnscrappedArticleException;
import ewha.nlsushi.newsum.repository.*;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScrapArticleService {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final ScrapArticleRepository scrapArticleRepository;
    private final ArticleService articleService;
    private final ScrapArticleRepositorySupport scrapArticleRepositorySupport;

    @Transactional
    public ScrapArticle scrapArticle(String userId, Long articlePK){
        Member member = memberRepository.findByUserId(userId);
        Article article = articleRepository.getById(articlePK);
        ScrapArticle scrapArticle = new ScrapArticle(member, article);
        return scrapArticleRepository.save(scrapArticle);
    }

    @Transactional
    public void unScrapArticle(String userId, Long articleId){
        Member user = memberRepository.findByUserId(userId);
        Optional<Article> article = articleRepository.findById(articleId);
        ScrapArticle target = scrapArticleRepositorySupport.findByUserIdandArticleId(userId,articleId);
        if(target == null){
            throw new UnScrapUnscrappedArticleException(ExceptionEnum.UNSCRAP_UNSCRAPPED_ARTICLE);
        }
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
