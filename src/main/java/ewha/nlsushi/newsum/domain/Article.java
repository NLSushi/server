package ewha.nlsushi.newsum.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="article")
@Getter
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String title;
    private String writer;
    private String date;
    private String company;

    private String img;
    private String article_origin;
    private String article_extractive;
    private String article_hashtag;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getCompany() {
        return company;
    }

    public String getImg() {
        return img;
    }

    public String getArticle_origin() {
        return article_origin;
    }

    public String getDate() {
        return date;
    }

    @Nullable
    public String getArticle_hashtag() {
        return article_hashtag;
    }

    public String getArticle_extractive() {
        return article_extractive;
    }

    public Article(Long id, String title, String writer, String date, String company, String img, String article_origin, String article_extractive, String article_hashtag) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.company = company;
        this.img = img;
        this.article_origin = article_origin;
        this.article_extractive = article_extractive;
        this.article_hashtag = article_hashtag;
    }
}
