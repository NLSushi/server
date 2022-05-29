package ewha.nlsushi.newsum;

import ewha.nlsushi.newsum.api.DTO.SignupRequest;
import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.domain.ScrapArticle;
import ewha.nlsushi.newsum.exception.Exception.ScrapArticleException;
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
        Assertions.assertThat(member.getScrapArticles().size()).isEqualTo(1);
    }
    @Test
    public void 스크랩해제하기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        ScrapArticle scrap = scrapArticleService.scrapArticle(member.getUserId(),article.getId());
        //when
        scrapArticleService.unScrapArticle(member.getUserId(),article.getId());
        //then
        Assertions.assertThat(member.getScrapArticles().size()).isEqualTo(0);
    }
    @Test(expected = ScrapArticleException.class)
    public void 스크랩안한기사스크랩해제Exception내기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        //when
        scrapArticleService.unScrapArticle(member.getUserId(), article.getId());
        //then
        Assertions.fail("예외 발생 안됨");
    }

    @Test(expected = ScrapArticleException.class)
    public void 스크랩기사조회시없는유저아이디Exception내기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        //when
        scrapArticleService.showScrapArticle("testfail");
        //then
        Assertions.fail("예외 발생 안됨");
    }
    @Test(expected = ScrapArticleException.class)
    public void 스크랩요청시없는유저아이디Exception내기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        //when
        scrapArticleService.scrapArticle("testfail",1L);
        //then
        Assertions.fail("예외 발생 안됨");
    }
    @Test(expected = ScrapArticleException.class)
    public void 스크랩요청시없는기사아이디Exception내기(){
        //given
        Article article =  articleRepository.save(new Article("스크랩기사","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        Member member = memberService.signup(new SignupRequest("scraptestmember"));
        //when
        scrapArticleService.scrapArticle("scraptestmember",300L);
        //then
        Assertions.fail("예외 발생 안됨");
    }





}
