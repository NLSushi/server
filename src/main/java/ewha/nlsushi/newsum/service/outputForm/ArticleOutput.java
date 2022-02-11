package ewha.nlsushi.newsum.service.outputForm;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class ArticleOutput {

    private String title;
    private String writer;
    private String date;
    private String company;

    private String img;
    private String[] article_origin;
    private String[] article_extractive;
    @Nullable
    private String[] article_hashtag;



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

    public String[] getArticle_origin() {
        return article_origin;
    }

    public String[] getArticle_extractive() {
        return article_extractive;
    }

    public String getDate() {
        return date;
    }

    public String[] getArticle_hashtag() {
        return article_hashtag;
    }

    public ArticleOutput(String title, String writer, String date, String company, String img, String article_origin, String article_extractive, @Nullable String article_hashtag) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.company = company;
        this.img = img;
        this.article_origin = article_origin.split("\n");
        this.article_extractive = article_extractive.split("\n");
        if(article_hashtag != null){
        this.article_hashtag = article_hashtag.split("#");}
        else this.article_hashtag = null;
    }
}
