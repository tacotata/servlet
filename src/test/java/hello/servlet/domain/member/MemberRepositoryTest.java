package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    //싱글톤이니까 new 사용안함 스프링 사용하면 싱글톤 사용할 필요없음 스프링 자체가 싱글톤 보장하니까까
   MemberRepository memberRepository = MemberRepository.getInstance();

   //test할 때마다 깔끔하게 지우는
   @AfterEach
    void afterEach(){
       //순서가 보장 안되니까 꼭 clearStore 해야함  테스트 끝날 때마다 요 아이가 지워줌
       memberRepository.clearStore();
   }

   @Test
   void save(){
       //given
       Member member = new Member("hello", 20);

       //when
       Member savedMember = memberRepository.save(member);

       //then
       Member findMember = memberRepository.findById(savedMember.getId());
       assertThat(findMember).isEqualTo(savedMember);
   }

   @Test
    void findAll(){

       //given
       Member member1 = new Member("member1", 20);
       Member member2 = new Member("member2", 30);

       memberRepository.save(member1);
       memberRepository.save(member2);

       //when
       List<Member> result = memberRepository.findAll();

       //then
       assertThat(result.size()).isEqualTo(2);
       //result안에 member1 , member2 있냐?
       assertThat(result).contains(member1, member2);

   }


}