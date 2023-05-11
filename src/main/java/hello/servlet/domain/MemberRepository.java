package hello.servlet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    //static을 사용했기 때문에 객체 하나만 공유하여 사용된다.
    private static Map<Long, Member> store = new HashMap<>();
    private static  Long sequence = 0L;

    //스프링이 아니라 서블릿으로 프로젝트를 진행할 것이기 때문에 싱글톤으로 설정해준다.
    private static final MemberRepository instance = new MemberRepository();

    //싱글톤 만들 때는 private으로 생성자를 막아야 한다. -> 아무나 생성하지 못하도록 한다.
    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store에 있는 모든 값들을 꺼내서 새로운 ArrayList에 넣어준다.
    }

    public void clearStore(){
        store.clear();     //store를 다 클리어 해준다.
    }
}
