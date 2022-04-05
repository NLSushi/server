package ewha.nlsushi.newsum.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="member")
@Getter
public class Member {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "member_pk")
    private Long id;

    @NonNull
    private String userId;

    @OneToMany(mappedBy = "scrap_member")
    List<ScrapArticle> scrap_articles = new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public Member(@NonNull String userId) {
        this.userId = userId;
    }
}
