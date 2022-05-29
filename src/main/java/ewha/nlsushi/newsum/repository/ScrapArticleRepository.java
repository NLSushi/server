package ewha.nlsushi.newsum.repository;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapArticleRepository extends JpaRepository<ScrapArticle,Long> {

    Optional<ScrapArticle> findByScrapMemberAndScrapArticle(long memberid, long articleid);

}
