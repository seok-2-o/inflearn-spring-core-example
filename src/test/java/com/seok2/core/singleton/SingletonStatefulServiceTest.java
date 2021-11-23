package com.seok2.core.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingletonStatefulServiceTest {

    @Test
    void order() {
        SingletonStatefulService service = SingletonStatefulService.getInstance();
        SingletonStatefulService service2 = SingletonStatefulService.getInstance();
        service.order("A", 1000);
        service2.order("B", 2000);
        System.out.println("price =" + service.getPrice());
        assertThat(service.getPrice()).isEqualTo(2000);
    }

}