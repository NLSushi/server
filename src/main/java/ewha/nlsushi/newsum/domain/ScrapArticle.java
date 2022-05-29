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
    @JsonIgnore
    private Member scrapMember;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private Article scrapArticle;

    public Member getScrap_member() {
        return scrapMember;
    }

    public Article getScrap_article() {
        return scrapArticle;
    }

    public ScrapArticle(Member scrap_member, Article scrap_article) {
        this.scrapMember = scrap_member;
        this.scrapArticle = scrap_article;
        scrap_article.scrapArticles.add(this);
        scrap_member.scrapArticles.add(this);
    }
}
