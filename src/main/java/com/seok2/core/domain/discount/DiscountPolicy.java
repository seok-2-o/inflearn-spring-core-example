package com.seok2.core.domain.discount;

import com.seok2.core.domain.member.data.Member;

public interface DiscountPolicy {

   int discount(Member member, int price);
}
