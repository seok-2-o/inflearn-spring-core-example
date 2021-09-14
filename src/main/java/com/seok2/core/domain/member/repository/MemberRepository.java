package com.seok2.core.domain.member.repository;

import com.seok2.core.domain.member.data.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
