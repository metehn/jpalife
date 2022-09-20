package listen.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import listen.entity.Living;

public class LivingPersist {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Living living = new Living();
        living.setFirstName("Metehan");
        living.setLastName("Ersoy");

        entityManager.getTransaction().begin();


        entityManager.persist(living);

        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println("Ad boş mu: " + living.isEmptyName() );
    }
}
