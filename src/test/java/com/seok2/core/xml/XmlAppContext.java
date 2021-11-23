package com.seok2.core.xml;

import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    public void xmlAppContext() {
        ApplicationContext ctx = new GenericXmlApplicationContext("appConfig.xml");
        assertThat(ctx.getBean(MemberRepository.class)).isInstanceOf(InMemoryMemberRepository.class);
    }

}
