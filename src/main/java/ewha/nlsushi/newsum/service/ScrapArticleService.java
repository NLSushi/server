package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.exception.ExceptionEnum;
import ewha.nlsushi.newsum.exception.Exception.ScrapArticleException;
import ewha.nlsushi.newsum.repository.*;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        handleNoUserIdException(member);
        try{
            Article article = articleRepository.getById(articlePK);
            ScrapArticle findArticle = scrapArticleRepositorySupport.findByUserIdandArticleId(userId,articlePK);
            if(findArticle !=null) handleAlreadyScrappedException();
            ScrapArticle scrapArticle = new ScrapArticle(member, article);
            log.info(member.getUserId()+" 회원 : "+article.getId()+" 기사 스크랩 완료");
            return scrapArticleRepository.save(scrapArticle);
        }
        catch (EntityNotFoundException | DataIntegrityViolationException e){
            handleNoArticleIdException();
        }

        return null;
    }

    @Transactional
    public void unScrapArticle(String userId, Long articleId){
        Member member = memberRepository.findByUserId(userId);
        handleNoUserIdException(member);
        try {
            Article article = articleRepository.getById(articleId);

            ScrapArticle target = scrapArticleRepositorySupport.findByUserIdandArticleId(userId, articleId);
            if (target == null) {
                throw new ScrapArticleException(ExceptionEnum.UNSCRAP_UNSCRAPPED_ARTICLE);
            }
            target.getScrap_article().getScrap_articles().remove(target);
            target.getScrap_member().getScrap_articles().remove(target);
            scrapArticleRepository.delete(target);
        }
        catch (EntityNotFoundException e){
            handleNoArticleIdException();
        }
    }

    public List<ArticleOutput> showScrapArticle(String userId){
        Member member = memberRepository.findByUserId(userId);
        handleNoUserIdException(member);
        List<ScrapArticle> scrapArticles = member.getScrap_articles();
        List<Article> articles = new ArrayList<>();
        for(ScrapArticle each: scrapArticles)
            articles.add(each.getScrap_article());
        return articleService.articleListToDTOList(articles);
    }

    //exception handling
    private void handleNoUserIdException(Member member){
        if(member == null){
            log.info("NoUserIdException 발생");
            throw new ScrapArticleException(ExceptionEnum.WRONG_USERID_FOR_SCRAP);
        }
    }
    private void handleNoArticleIdException(){
            log.info("NoArticleIdException 발생");
            throw new ScrapArticleException(ExceptionEnum.WRONG_ARTICLEID_FOR_SCRAP);
    }
    private void handleAlreadyScrappedException(){
        log.info("AlreadyScrappedException 발생");
        throw new ScrapArticleException(ExceptionEnum.ALREADY_SCRAPPED);
    }
}
