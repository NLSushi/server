package ewha.nlsushi.newsum;

import ewha.nlsushi.newsum.api.requestform.SignupRequest;
import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.service.ArticleService;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ArticleTest {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleRepository articleRepository;

    @Before
    public void 초기데이터설정(){
        articleRepository.save(new Article("제목","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
    }

    @Test
    public void 검색기능테스트(){
        //given
        articleRepository.save(new Article("제목","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그","카테고리",false));
        articleRepository.save(new Article("제목","작성자","날짜","회사","이미지","기사원문","기사요약","해시태그2","카테고리",false));
        //when
        List<ArticleOutput> output = articleService.SearchArticlesByHashTag("해시태그");
        //then
        Assertions.assertThat(output.size()).isEqualTo(2);
    }
}
