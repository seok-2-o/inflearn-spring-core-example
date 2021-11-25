package com.seok2.core.beandefinition.configuration;

import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {


    @Test
    @DisplayName("싱글톤 테스트")
    void getRepository() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MemberService ms = ctx.getBean("memberService", MemberService.class);
        OrderService os = ctx.getBean("orderService", OrderService.class);
        MemberRepository mr = ctx.getBean("memberRepository", MemberRepository.class);

        assertThat(ms.getMemberRepository()).isSameAs(os.getMemberRepository());
        assertThat(ms.getMemberRepository()).isSameAs(mr);
        assertThat(os.getMemberRepository()).isSameAs(mr);
    }

    @Test
    @DisplayName("싱글톤을 보장하는 방법")
    void deep() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        AppConfiguration configuration  = ctx.getBean(AppConfiguration.class);
        System.out.println("configuration = " + configuration.getClass());

    }
}
