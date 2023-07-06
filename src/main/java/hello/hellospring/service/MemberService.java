package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    //회원 가입
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원
        vaildateDuplicatemember(member);
        memberRepository.save(member);

        return member.getId();
    }
    private void vaildateDuplicatemember(Member member){
        // ifPresent -> optional 메소드 result에 값이 있으면 안에 로직이 동작한다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 아이디로 회원조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
