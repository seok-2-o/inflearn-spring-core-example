package com.seok2.core.domain.discount;

import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    /**
     * @return 할인 금액
     */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return 1000;
        }
        return 0;
    }
}
