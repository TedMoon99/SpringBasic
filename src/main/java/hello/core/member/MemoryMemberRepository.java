package hello.core.member;

import java.util.HashMap;

public class MemoryMemberRepository implements MemberRepository{

    private static HashMap<Long, Member> store = new HashMap<>(); // HashMap을 쓸 경우 동시성 이슈가 터질 수 있지만 개발 용도로만 단순하게 사용해보자

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
