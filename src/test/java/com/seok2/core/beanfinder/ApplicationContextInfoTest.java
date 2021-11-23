package com.seok2.core.beanfinder;


import com.seok2.core.config.AppConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);



    @Test
    @DisplayName("모든 빈 가져오기")
    void findAll() {
        String [] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            Object bean = ctx.getBean(name);
            System.out.println("name = "+ name + " object = " + bean);
        }
    }
    @Test
    @DisplayName("모든 빈 가져오기")
    void findApplicationBeans() {
        String [] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition definition = ctx.getBeanDefinition(name);
            if(definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ctx.getBean(name);
                System.out.println("name = "+ name + " object = " + bean);
            }

        }
    }
}
