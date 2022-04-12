package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.api.SignupRequest;
import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.repository.MemberRepository;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(SignupRequest request){
        Member member = new Member(request.getUserId());
        memberRepository.save(member);
        return member;
    }

}
