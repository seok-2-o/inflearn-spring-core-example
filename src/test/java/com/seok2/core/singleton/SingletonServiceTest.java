package com.seok2.core.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingletonServiceTest {

    @Test
    void call() {
        SingletonService service = SingletonService.getInstance();
        SingletonService service2 = SingletonService.getInstance();
        assertThat(service).isSameAs(service2);
    }

}