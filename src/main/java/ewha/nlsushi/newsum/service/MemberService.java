package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.api.requestform.SignupRequest;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.exception.Entity.UserAccountExceptionEntity;
import ewha.nlsushi.newsum.exception.Exception.UserAccountException;
import ewha.nlsushi.newsum.exception.ExceptionEnum;
import ewha.nlsushi.newsum.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(SignupRequest request){
        Member member = new Member(request.getUserId());
        handleIdAlreadyExistsException(request.getUserId());
        memberRepository.save(member);
        return member;
    }

    //Exception Handling
    private void handleIdAlreadyExistsException(String id){
        if(memberRepository.findByUserId(id)!= null){
            throw new UserAccountException(ExceptionEnum.ID_ALREADY_EXISTS);
        }
    }

}
