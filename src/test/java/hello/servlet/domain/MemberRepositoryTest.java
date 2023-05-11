package hello.servlet.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){ //테스트가 하나가 끝나면 테스트를 초기화 해준다.
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given : ~한 것이 주어지고
        Member member = new Member("hello",20);
        //when : ~한 것을 실행했을 때
        Member saveMember = memberRepository.save(member);
        //then : 결과가 ~ 이어야 한다.
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findALl(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 32);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> memberList = memberRepository.findAll();
        //then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);
    }



}