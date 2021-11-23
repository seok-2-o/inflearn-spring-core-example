package com.seok2.core.beandefinition;

import com.seok2.core.config.AppConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBeans() {
        String [] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition definition = ctx.getBeanDefinition(name);
            if(definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + name + " definition = " + definition);
            }
        }


    }

}
