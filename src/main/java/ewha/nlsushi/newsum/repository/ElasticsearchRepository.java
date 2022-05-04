package ewha.nlsushi.newsum.repository;

import ewha.nlsushi.newsum.domain.HashTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticsearchRepository extends org.springframework.data.elasticsearch.repository.ElasticsearchRepository<HashTag,String> {
    @Query("{\"match\":{\"tag\":\"?0\"}}")
    List<HashTag> findByTag(String tag);
}
