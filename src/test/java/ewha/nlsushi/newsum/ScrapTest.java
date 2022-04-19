package ewha.nlsushi.newsum;

import ewha.nlsushi.newsum.api.requestform.SignupRequest;
import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.service.MemberService;
import ewha.nlsushi.newsum.service.ScrapArticleService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ScrapTest {

    @Autowired
    ScrapArticleService scrapArticleService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    MemberService memberService;

    //String title, String writer, String date, String company, String img, String article_origin, String article_extractive, String article_hashtag, String category,boolean recent)
    @Before
    public void 초기데이터설정(){
        articleRepository.save(new Article("제목","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        memberService.signup(new SignupRequest("testmember"));
    }

    @Test
    public void 스크랩하기(){
        //given
       Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        //when
        scrapArticleService.scrapArticle(member.getUserId(),article.getId());
        //then
        Assertions.assertThat(member.getScrap_articles().size()).isEqualTo(1);
    }
    @Test
    public void 스크랩해제하기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        ScrapArticle scrap = scrapArticleService.scrapArticle(member.getUserId(),article.getId());
        //when
        scrapArticleService.UnScrapArticle(scrap.getId());
        //then
        Assertions.assertThat(member.getScrap_articles().size()).isEqualTo(0);
    }
}
