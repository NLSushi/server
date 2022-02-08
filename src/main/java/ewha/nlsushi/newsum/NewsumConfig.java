package ewha.nlsushi.newsum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class NewsumConfig {

    @PersistenceContext
    private EntityManager entityManager;

}
