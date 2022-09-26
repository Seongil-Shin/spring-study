package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JDBCMemberRepository;
import hello.hellospring.repository.JPAMemberRepogitory;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRegository) {
        this.memberRepository = memberRegository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
////
////    @Bean
////    public MemberRepository memberRepository() {
//
//        //eturn new JDBCMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//      //  return new JPAMemberRepogitory(em);
//
//    }

}
