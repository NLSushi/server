package ewha.nlsushi.newsum.api.response;

import ewha.nlsushi.newsum.domain.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArticleResponse {

    @ApiModelProperty(example = "기사 아이디")
    private Long id;
    @ApiModelProperty(example = "제목")
    private String title;
    @ApiModelProperty(example = "기자")
    private String writer;
    @ApiModelProperty(example = "기사 작성 날짜")
    private String date;
    @ApiModelProperty(example = "언론사")
    private String company;

    @ApiModelProperty(example = "기사 사진 주소")
    private String img;
    @ApiModelProperty(example = "기사원문")
    private String[] article_origin;
    @ApiModelProperty(example = "기사추출요약문 (3줄요약)")
    private String[] article_extractive;
    @Nullable
    @ApiModelProperty(example = "해시태그")
    private String[] article_hashtag;
    @ApiModelProperty(example = "기사 카테고리(정치/경제/사회)")
    private String category;


    @Builder
    public ArticleResponse(Long id, String title, String writer, String date, String company, String img, String article_origin, String article_extractive, @Nullable String article_hashtag, String category) {
        this.id = id;
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
        this.category = category;
    }

    public static List<ArticleResponse> articleListToDTOList(List<Article> articleList){
        List<ArticleResponse> result = articleList.stream().map(a ->
                new ArticleResponse(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }
}
