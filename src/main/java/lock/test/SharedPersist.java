package lock.test;

import cache.entity.Frequent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lock.entity.Shared;

public class SharedPersist {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Shared shared = new Shared();
        shared.setSharedName("Shared");

        entityManager.getTransaction().begin();

        entityManager.persist(shared);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
