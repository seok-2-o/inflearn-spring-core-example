package com.seok2.core.domain.member.service;

import com.seok2.core.config.AppConfiguration;
import com.seok2.core.domain.member.data.Grade;
import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    private final AppConfiguration configuration = new AppConfiguration();
    private final MemberService service = configuration.memberService();

    @Test
    public void join() {
        //given
        Member member = new Member(1l, "seok2", Grade.VIP);

        //when
        service.join(member);
        Member saved = service.findById(1l);

        //then
        assertThat(member).isEqualTo(saved);
    }
}