package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
//  싱글톤으로해서 static 없어도 되긴함
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

//    싱글톤만들 때 private으로 생성자 막아서 아무나 생성못하게 해야함  무조건 아래로 조회해야함
    private static final MemberRepository instance = new MemberRepository();
    public  static  MemberRepository getInstance(){
        return  instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return  store.get(id);
    }

    //store에 있는 values를 건들고 싶지 않아서 이렇게 함 store 자체를 보호하기 위해서
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //이건 테스트 위해서
    public  void clearStore(){
        store.clear();
    }
}
