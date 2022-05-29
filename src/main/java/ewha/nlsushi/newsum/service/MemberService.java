package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.api.DTO.SignupRequest;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.exception.Exception.UserAccountException;
import ewha.nlsushi.newsum.exception.ExceptionEnum;
import ewha.nlsushi.newsum.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(SignupRequest request){
        Optional<Member> member = memberRepository.findByUserId(request.getUserId());
        if(member.isPresent()) throw new UserAccountException(ExceptionEnum.ID_ALREADY_EXISTS);

        Member newMember = new Member(request.getUserId());
        memberRepository.save(newMember);

        log.info(newMember.getUserId() +" 회원가입");
        return newMember;
    }


}
