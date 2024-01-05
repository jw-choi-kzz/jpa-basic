package jpabasic.reserve.jpa;
/*
 * EntityManager를 쉽게 구하기 위한 보조 클래스
 * EntityManager를 계속 들고다녀야 하는 불편함 -> EntityManager를 static으로 담고 있음
 * EntityManager가 필요하면 createEntityManager 메서드를 사용
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {
    private static EntityManagerFactory emf;

    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
