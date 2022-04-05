package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping(value = "api/{userId}/signup")
    public Member signup(@PathVariable("userId")String userId){
       return memberService.signup(userId);
    }
}
