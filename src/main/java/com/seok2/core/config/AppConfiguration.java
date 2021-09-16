package com.seok2.core.config;

import com.seok2.core.domain.discount.DiscountPolicy;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.discount.RateDiscountPolicy;
import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.service.OrderService;

public class AppConfiguration {

    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderService(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
