package ewha.nlsushi.newsum.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name="scrap_article")
@Getter
public class ScrapArticle {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="scrap_pk")
    Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "member_pk")
  //  @JsonManagedReference
    @JsonIgnore
    private Member scrap_member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Article scrap_article;

    public Member getScrap_member() {
        return scrap_member;
    }

    public Article getScrap_article() {
        return scrap_article;
    }

    public ScrapArticle(Member scrap_member, Article scrap_article) {
        this.scrap_member = scrap_member;
        this.scrap_article = scrap_article;
        scrap_article.scrap_articles.add(this);
        scrap_member.scrap_articles.add(this);
    }
}
