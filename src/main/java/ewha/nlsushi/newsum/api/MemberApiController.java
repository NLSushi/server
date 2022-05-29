package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.api.DTO.SignupRequest;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.service.MemberService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="멤버 회원 가입",notes="멤버의 id를 받아서 해당 멤버의 회원 정보를 저장합니다.")
    public Member signup(@RequestBody @Valid SignupRequest request) {
        return memberService.signup(request);
    }



}
