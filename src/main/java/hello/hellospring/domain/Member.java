package hello.hellospring.domain;

import javax.persistence.*;

@Entity
@Table(name = "member")
@SequenceGenerator(
        name="MEMBER_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="MEMBER_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GEN"
    )
    private Long id;
    private String name;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
