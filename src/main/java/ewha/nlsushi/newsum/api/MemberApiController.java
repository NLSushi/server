package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.api.requestform.SignupRequest;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping(value = "api/signup")
    public Member signup(@RequestBody @Valid SignupRequest request)
    { return memberService.signup(request);
    }



}
