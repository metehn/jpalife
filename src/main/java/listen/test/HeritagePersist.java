package listen.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import listen.entity.Kid;
import listen.entity.Living;

public class HeritagePersist {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Kid kid = new Kid();
        kid.setNameField("Metehan");


        entityManager.getTransaction().begin();


        entityManager.persist(kid);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
