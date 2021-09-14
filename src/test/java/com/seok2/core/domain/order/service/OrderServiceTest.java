package com.seok2.core.domain.order.service;

import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.service.MemberService;
import com.seok2.core.domain.order.data.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();
    private final MemberService memberService = new MemberService();

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