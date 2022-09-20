package lock.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import lock.entity.Shared;

public class LockTrier {


    public static void main(String[] args) {

        long sharedId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();


        Shared shared = entityManager.find(Shared.class, sharedId);

        entityManager.getTransaction().begin();

        shared.setSharedName("Shared 3");

        entityManager.merge(shared);

        entityManager.getTransaction().commit();

        entityManager.close();


    }


}
