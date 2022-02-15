package ewha.nlsushi.newsum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class NewsumApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "./app/config/newsum/real-application.yml";
    public static void main(String[] args) {
        new SpringApplicationBuilder(NewsumApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
