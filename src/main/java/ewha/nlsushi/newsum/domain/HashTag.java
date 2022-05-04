package ewha.nlsushi.newsum.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "tags")
@Getter
public class HashTag {

    @Id @GeneratedValue
    private String id;
    private String tag;

}
