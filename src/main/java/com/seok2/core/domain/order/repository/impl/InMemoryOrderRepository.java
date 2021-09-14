package com.seok2.core.domain.order.repository.impl;

import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.order.data.Order;
import com.seok2.core.domain.order.repository.OrderRepository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository implements OrderRepository {

    private final static Map<Long, Order> STORE = new ConcurrentHashMap<>();
    private static long idx = 1;

    @Override
    public Long save(Order order) {
        Long id = order.getId();
        if(Objects.isNull(id)) {
            STORE.put(idx, order);
            return idx++;
        }
        STORE.put(id, order);
        return id;
    }



}
