package ewha.nlsushi.newsum.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ewha.nlsushi.newsum.domain.Article;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ewha.nlsushi.newsum.domain.QArticle.article;

@Repository
public class ArticleRepositorySupport extends QuerydslRepositorySupport {

        private final JPAQueryFactory queryFactory;

        public ArticleRepositorySupport(JPAQueryFactory queryFactory){
            super(Article.class);
            this.queryFactory = queryFactory;
        }
        public List<Article> findJoongangRecent(){
            return queryFactory
                    .selectFrom(article)
                    .where(article.company.eq("중앙일보"))
                    .where(article.recent.eq(true))
                    .fetch();
        }
    public List<Article> findKhanRecent(){
        return queryFactory
                .selectFrom(article)
                .where(article.company.eq("경향신문"))
                .where(article.recent.eq(true))
                .fetch();
    }
    public List<Article> findHanRecent(){
        return queryFactory
                .selectFrom(article)
                .where(article.company.eq("한겨레"))
                .where(article.recent.eq(true))
                .fetch();
    }

    public List<Article> findRecent() {
            return queryFactory
                    .selectFrom(article)
                    .where(article.recent.eq(true))
                    .fetch();
    }
}
