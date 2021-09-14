package com.seok2.core.domain.member.repository.impl;

import com.seok2.core.domain.member.data.Member;
import com.seok2.core.domain.member.repository.MemberRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMemberRepository implements MemberRepository {
    private final static Map<Long, Member> STORE = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        STORE.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return STORE.get(id);
    }
}
