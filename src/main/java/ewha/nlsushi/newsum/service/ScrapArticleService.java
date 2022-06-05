package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.exception.ExceptionEnum;
import ewha.nlsushi.newsum.exception.Exception.ScrapArticleException;
import ewha.nlsushi.newsum.repository.*;
import ewha.nlsushi.newsum.api.response.ArticleResponse;
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

    @Transactional
    public ScrapArticle scrapArticle(String userId, Long articleId) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new ScrapArticleException(ExceptionEnum.WRONG_USERID_FOR_SCRAP));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ScrapArticleException(ExceptionEnum.WRONG_ARTICLEID_FOR_SCRAP));

        Optional<ScrapArticle> findArticle = scrapArticleRepository.
                findByScrapMemberAndScrapArticle(member, article);
        if (findArticle.isPresent()) throw new ScrapArticleException(ExceptionEnum.ALREADY_SCRAPPED);

        ScrapArticle scrapArticle = new ScrapArticle(member, article);
        log.info(member.getUserId() + " 회원 : " + article.getId() + " 기사 스크랩 완료");

        return scrapArticleRepository.save(scrapArticle);
    }

    @Transactional
    public void unScrapArticle(String userId, Long articleId) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new ScrapArticleException(ExceptionEnum.WRONG_USERID_FOR_SCRAP));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ScrapArticleException(ExceptionEnum.WRONG_ARTICLEID_FOR_SCRAP));

        ScrapArticle target = scrapArticleRepository
                .findByScrapMemberAndScrapArticle(member, article)
                .orElseThrow(()->new ScrapArticleException(ExceptionEnum.UNSCRAP_UNSCRAPPED_ARTICLE));

        target.getScrap_article().getScrapArticles().remove(target);
        target.getScrap_member().getScrapArticles().remove(target);
        scrapArticleRepository.delete(target);

        log.info(member.getUserId() + " 회원 : " + article.getId() + " 기사 스크랩 취소");
        }



    public List<ArticleResponse> showScrapArticle(String userId) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new ScrapArticleException(ExceptionEnum.WRONG_USERID_FOR_SCRAP));

        List<ScrapArticle> scrapArticles = member.getScrapArticles();
        List<Article> articles = new ArrayList<>();
        for (ScrapArticle each : scrapArticles)
            articles.add(each.getScrap_article());

        log.info(member.getUserId() + " 회원의 스크랩 기사 리스트 조회, 총 스크랩 기사 갯수 : "+articles.size()+"개");
        return ArticleResponse.articleListToDTOList(articles);
    }


}
