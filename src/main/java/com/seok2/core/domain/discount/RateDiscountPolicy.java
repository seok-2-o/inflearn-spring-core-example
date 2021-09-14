package com.seok2.core.domain.discount;

import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final int DEFAULT_DISCOUNT_PERCENT = 10 ;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * DEFAULT_DISCOUNT_PERCENT / 100;
        }
        return 0;
    }
}
