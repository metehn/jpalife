package cache.test;

import cache.entity.Frequent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FirstLevelTest {


    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Frequent frequent = new Frequent(0, "Deneme");

        entityManager.getTransaction().begin();


        entityManager.persist(frequent);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
