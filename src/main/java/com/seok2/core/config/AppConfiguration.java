package com.seok2.core.config;

import com.seok2.core.domain.discount.DiscountPolicy;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.discount.RateDiscountPolicy;
import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
