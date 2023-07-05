package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    // 인터페이스 속성의 객체를 선언하되 객체는 클래스
    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("찬규");

        repository.save(member);
        // 마지막 .get()은 optianal 타입이기에 사용가능함.
        Member result = repository.findById(member.getId()).get();

        Assertions.assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("오리");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("구리");
        repository.save(member2);

        Member result = repository.findByName("구리").get();

        Assertions.assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("오리");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("구리");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
