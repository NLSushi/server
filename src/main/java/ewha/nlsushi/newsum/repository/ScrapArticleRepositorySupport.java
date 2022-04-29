package ewha.nlsushi.newsum.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ewha.nlsushi.newsum.domain.QArticle;
import ewha.nlsushi.newsum.domain.QMember;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

import static ewha.nlsushi.newsum.domain.QScrapArticle.scrapArticle;

@Repository
public class ScrapArticleRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;
    private QArticle article;
    private QMember member;

    public ScrapArticleRepositorySupport(JPAQueryFactory queryFactory) {
        super(ScrapArticle.class);
        this.queryFactory = queryFactory;
    }

    public ScrapArticle findByUserIdandArticleId(String userId, Long articleId){
        try{return queryFactory.select(scrapArticle)
                .from(scrapArticle)
                .distinct()
               .where(scrapArticle.scrap_article.id.eq(articleId))
                .where(scrapArticle.scrap_member.userId.eq(userId))
                .fetchOne();}
        catch (NoResultException nre){
            return null;
        }
    }
}
