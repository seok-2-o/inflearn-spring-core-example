package com.seok2.core.beanfinder;

import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.discount.DiscountPolicy;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.discount.RateDiscountPolicy;
import com.seok2.core.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFinderTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DuplicationAppConfiguration.class);

    @Configuration
    static class DuplicationAppConfiguration {

        @Bean
        public DiscountPolicy fdp() {
            return new FixedDiscountPolicy();
        }

        @Bean
        public DiscountPolicy rdp() {
            return new RateDiscountPolicy();
        }
    }

    @Test
    @DisplayName("같은 타입이 두개 존재 할 경우 에러가 발생한다.")
    void findByBeanType() {
        assertThatThrownBy(() -> ctx.getBean(DiscountPolicy.class)).isInstanceOf(NoUniqueBeanDefinitionException.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ctx.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("같은 타입이 두개 존재 할 경우 이름으로 조회")
    void findByBeanName() {
        assertThat(ctx.getBean("fdp", DiscountPolicy.class)).isInstanceOf(FixedDiscountPolicy.class);
        assertThat(ctx.getBean("rdp", DiscountPolicy.class)).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllByType() {
        Map<String, DiscountPolicy> beans = ctx.getBeansOfType(DiscountPolicy.class);
        for (Map.Entry<String, DiscountPolicy> entry : beans.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
        assertThat(beans.size()).isEqualTo(2);
    }
}
