package ewha.nlsushi.newsum.service.outputForm;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ArticleOutput {

    private String title;
    private String writer;
    private String company;

    private String img;
    private String article_origin;
    private String article_extractive;


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

    public String getArticle_extractive() {
        return article_extractive;
    }

    public ArticleOutput(String title, String writer, String company, String img, String article_origin, String article_extractive) {
        this.title = title;
        this.writer = writer;
        this.company = company;
        this.img = img;
        this.article_origin = article_origin;
        this.article_extractive = article_extractive;
    }
}
