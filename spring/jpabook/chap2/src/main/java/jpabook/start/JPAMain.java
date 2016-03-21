package jpabook.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = factory.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction transaction = manager.getTransaction(); //트랜잭션 기능 획득

        try {
            transaction.begin(); //트랜잭션 시작
            logic(manager);  //비즈니스 로직
            transaction.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback(); //트랜잭션 롤백
        } finally {
            manager.close(); //엔티티 매니저 종료
        }

        factory.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager manager) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        manager.persist(member);

        //수정
        member.setAge(20);

        //한 건 조회
        Member findMember = manager.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername()
                + ", age=" + findMember.getAge());

        //목록 조회
        List<Member> members = manager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        manager.remove(member);
    }
}
