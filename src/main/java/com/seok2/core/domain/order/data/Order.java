package com.seok2.core.domain.order.data;

import com.seok2.core.domain.member.data.Member;

import java.util.StringJoiner;

public class Order {

    private Long id;
    private Long memberId;
    private String name;
    private int price;
    private int benefit;

    public Order(Member member, String name, int price, int benefit) {
        this.memberId = member.getId();
        this.name = name;
        this.price = price;
        this.benefit = benefit;
    }

    public Long getId() {
        return id;
    }

    public int getSalesPrice() {
        return this.price - this.benefit;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId=" + memberId)
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("benefit=" + benefit)
                .toString();
    }
}
