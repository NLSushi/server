package ewha.nlsushi.newsum.repository;

import ewha.nlsushi.newsum.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

List<Article> findByRecent(boolean recent);
List<Article> findByHashtag(String hashtag);
List<Article> findByCompanyAndRecent(String company, boolean recent);
}
