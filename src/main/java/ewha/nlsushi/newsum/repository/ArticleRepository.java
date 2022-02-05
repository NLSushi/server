package ewha.nlsushi.newsum.repository;

import ewha.nlsushi.newsum.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

}
