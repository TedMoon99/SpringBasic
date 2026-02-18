package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /*
    아래의 코드는
    MemberRepository라는 추상화에도 의존하고
    MemoryMemberRepository라는 구체화에도 의존한다는
    DIP(Dependency Inversion Principle) 원칙 위반이 있다
    */
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository; // 생성자 주입

    /*
    * Dependency Injection (의존성 주입)
    * MemberServiceImpl의 입장에서는 마치 의존관계를 외부에서 넣어주는 것으로 보인다.
    * 이러한 관계가 형성되었을 때 Dependency Injection이라고 한다
    * */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
