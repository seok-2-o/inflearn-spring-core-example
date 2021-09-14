package com.seok2.core.domain.order.service;

import com.seok2.core.domain.discount.DiscountPolicy;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import com.seok2.core.domain.order.data.Order;

public class OrderService {

    private final MemberRepository memberRepository = new InMemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();

    public Order create(Long memberId, String name, int price) {
        Member member = memberRepository.findById(memberId);
        int benefit = discountPolicy.discount(member, price);
        return new Order(member, name, price, benefit);
    }
}
