package com.seok2.core.domain.order.service;

import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.discount.FixedDiscountPolicy;
import com.seok2.core.domain.discount.RateDiscountPolicy;
import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.data.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    private final AppConfiguration configuration = new AppConfiguration();
    private final OrderService orderService = configuration.orderService();
    private final MemberService memberService = configuration.memberService();

    @Test
    public void create() {
        Long memberId = 1L;

        Member member = new Member(memberId, "s", Grade.VIP);
        memberService.join(member);

        Order order = orderService.create(memberId, "마스크", 10000);

        assertThat(order.getSalesPrice()).isEqualTo(9000);
        System.out.println(order);

    }
}