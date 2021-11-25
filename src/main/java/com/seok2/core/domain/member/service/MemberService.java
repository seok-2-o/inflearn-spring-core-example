package com.seok2.core.domain.member.service;

import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.repository.MemberRepository;
import com.seok2.core.domain.member.repository.impl.InMemoryMemberRepository;

public class MemberService {

    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
