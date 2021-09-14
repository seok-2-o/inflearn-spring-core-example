package com.seok2.core.domain.discount;

import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RateDiscountPolicyTest {

    private DiscountPolicy policy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 등급은 10% 할인이 적용 된다.")
    public void discount() {
       int discounted = policy.discount(new Member(1l, "s", Grade.VIP), 10000);
       assertThat(discounted).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP 등급이 아니면 할인이 적용되지 않는다.")
    public void discount2() {
        int discounted = policy.discount(new Member(1l, "s", Grade.BASIC), 10000);
        assertThat(discounted).isEqualTo(0);
    }
}