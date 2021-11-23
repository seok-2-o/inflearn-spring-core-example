package com.seok2.core.beanfinder;


import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByBeanName() {
        MemberService service = ctx.getBean("memberService", MemberService.class);
        assertThat(service).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("빈 타입으로 조회")
    void findByBeanType() {
        MemberService service = ctx.getBean(MemberService.class);
        assertThat(service).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findByUnknownName() {
        assertThatThrownBy(() -> ctx.getBean("Unknown")).isInstanceOf(NoSuchBeanDefinitionException.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ctx.getBean("Unknown"));
    }

}
