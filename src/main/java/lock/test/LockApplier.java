package lock.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import lock.entity.Shared;

public class LockApplier {

    public static void main(String[] args) {

        long sharedId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        //Not: kitleme transaction içinde olmak zorunda!


        //Shared shared = entityManager.find(Shared.class, sharedId);
        //entityManager.lock(shared, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
        Shared shared = entityManager.find(Shared.class, sharedId, LockModeType.PESSIMISTIC_FORCE_INCREMENT); // Yurakıdaki gibi de yapılabilirdi, böyle bulduğu gibi kitledi
        shared.setSharedName("Shared 2");

        System.out.println("Sürüm numarası: "+ shared.getVersionNumber());

        /*
        LockModeType.OPTIMISTIC
        LockModeType.NONE
        LockModeType.OPTIMISTIC_FORCE_INCREMENT
        LockModeType.PESSIMISTIC_FORCE_INCREMENT
        LockModeType.PESSIMISTIC_READ
        LockModeType.PESSIMISTIC_WRITE
        LockModeType.READ
        LockModeType.WRITE
         */

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Süre geçti güncelleniyor");
        entityManager.merge(shared);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
