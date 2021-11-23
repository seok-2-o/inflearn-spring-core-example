package com.seok2.core.singleton;

import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

    @Test
    void pure() {
        AppConfiguration configuration = new AppConfiguration();
        MemberService ms1 = configuration.memberService();
        MemberService ms2 = configuration.memberService();
        assertThat(ms1).isNotSameAs(ms2);
        assertThat(ms1).isNotEqualTo(ms2);
    }

    @Test
    void singleton() {
        MemberService ms1 = ctx.getBean(MemberService.class);
        MemberService ms2 = ctx.getBean(MemberService.class);
        assertThat(ms1).isSameAs(ms2);
        assertThat(ms1).isEqualTo(ms2);

    }


}
