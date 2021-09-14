package com.seok2.core.domain.order.repository;

import com.seok2.core.domain.order.data.Order;

public interface OrderRepository {

    Long save(Order order);
}
