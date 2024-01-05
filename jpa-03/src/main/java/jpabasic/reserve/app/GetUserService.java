package jpabasic.reserve.app;
/*
 * 조회 - EntityManager #find(Class <T> entityClass, Object primaryKey)
 * 인자 1: entityClass로 mapping 설정한 클래스, 인자 2: 식별자에 해당하는 값 전달
 */
import jakarta.persistence.EntityManager;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.createEntityManager();
        try {
            User user = em.find(User.class, email); //User.class에 mapping된 table에서 PK가 email인 데이터 조회
            // * 엔티티 타입, ID(PK) 타입이 일치하지 않으면 Exception 발생 
            if (user == null) { //find에서 중요한 부분. 조회했는데 null인 경우의 처리
                throw new NoUserException();
            }
            return user;
        } finally {
            em.close();
        }
    }
}
