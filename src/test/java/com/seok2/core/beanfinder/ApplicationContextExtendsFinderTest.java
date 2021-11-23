package com.seok2.core.beanfinder;

import com.seok2.core.domain.discount.DiscountPolicy;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFinderTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExtendsAppConfiguration.class);

    @Configuration
    static class ExtendsAppConfiguration {

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
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 존재하면, 중복 오류가 발생한다.")
    void findByParent() {
        assertThatThrownBy(() -> ctx.getBean(DiscountPolicy.class)).isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식 이름을 지정하면 오류를 피할 수 있다.")
    void findByParentAndName() {
        assertThat(ctx.getBean("fdp", DiscountPolicy.class)).isInstanceOf(FixedDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findByType() {
        assertThat(ctx.getBean(FixedDiscountPolicy.class)).isInstanceOf(FixedDiscountPolicy.class);
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

    @Test
    @DisplayName("Object 타입으로 조회해보기")
    void findAllByObject() {
        Map<String, Object> beans = ctx.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
    }
}
