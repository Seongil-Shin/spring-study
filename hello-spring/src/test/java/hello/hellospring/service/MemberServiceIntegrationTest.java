package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    @Commit
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Assertions.assertThat(member.getName()).isEqualTo(memberService.findOne(saveId).get().getName());
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        // try-catch 문법
        try {
            memberService.join(member2);
            fail("예외가 발생해야합니다.");
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        // 짧은 문법
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then
    }
}
