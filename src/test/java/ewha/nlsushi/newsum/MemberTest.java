package ewha.nlsushi.newsum;

import ewha.nlsushi.newsum.api.requestform.SignupRequest;
import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.exception.Exception.ScrapArticleException;
import ewha.nlsushi.newsum.exception.Exception.UserAccountException;
import ewha.nlsushi.newsum.service.MemberService;
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
public class MemberTest {

    @Autowired
    MemberService memberService;
    @Test(expected = UserAccountException.class)
    public void 아이디중복예외처리(){
        //given
        memberService.signup(new SignupRequest("testmember"));
        //when
        memberService.signup(new SignupRequest("testmember"));
        //then
        Assertions.fail("예외 발생 안됨");
    }
}
