package main;

import jakarta.persistence.*;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        
        //영속 단위 기준으로 초기화
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpabegin"); //영속 단위 기준으로 초기화. 필요한 자원 생성
        //jpabegin은 persistense.xml에서 정의한 영속 단위 기준 이름
 
        //EntityManager로 DB 연동
        EntityManager entityManager = emf.createEntityManager(); //실제 db 연동을 처리. EntityManager 한번만 생성.
        EntityTransaction transaction = entityManager.getTransaction(); //EntityTransaction을 구함
        try {
            transaction.begin(); //transaction 시작
            User user = new User("user@user.com", "user", LocalDateTime.now());
            entityManager.persist(user); //persist 메서드 호출로 user 파라미터가 DB에 저장  
            transaction.commit(); //transaction 커밋
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback(); //transaction 롤백
        } finally {
            entityManager.close(); //Exception 발생 여부와 상관없이 (finally) entityManager 닫음
        }

        emf.close(); //팩토리 닫음. 사용한 자원 반환
    }
}
