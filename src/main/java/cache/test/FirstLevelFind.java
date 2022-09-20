package cache.test;

import cache.entity.Frequent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FirstLevelFind {


    public static void main(String[] args) {

        long frequentId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");

        /*
        Frequent frequent1 = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent1);

        Frequent frequent2 = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent2);

        Çıktı şöle olacak: (Çıktıdaki instance numaraları değişebilir)

            cache.entity.Frequent@6949e948
            cache.entity.Frequent@6949e948

        iki nesnenin de instance numarası aynı. entitymanager veritabanına tekrar gidip nesneyi almadı,
        veriyi kendiliğinden cachledi ve oradan getiriyor. Bu, duruma göre yararlı ve ya zararlı olabilir.
        Mesela veritabanında kayıt değiştiğinde güncel veriyi getirmek yerine cachelediği veriyi getirir!

         */

        EntityManager entityManager1 = factory.createEntityManager();

        Frequent frequent1a = entityManager1.find(Frequent.class, frequentId);
        System.out.println(frequent1a);

        entityManager1.refresh(frequent1a); //Instance numarası değişmeyecek ama nesneyi veritabanından tekrar alacak.

        Frequent frequent1b = entityManager1.find(Frequent.class, frequentId);
        System.out.println(frequent1b);

        entityManager1.close();


        EntityManager entityManager2 = factory.createEntityManager();
        Frequent frequent2 = entityManager2.find(Frequent.class, frequentId);
        System.out.println(frequent2);

        entityManager2.close();

        /*
        Çıktı şöle olacak: (Çıktıdaki instance numaraları değişebilir)

            cache.entity.Frequent@6949e948
            cache.entity.Frequent@6949e948
            cache.entity.Frequent@21a02556

        iki farklı entityManager yarattım, ikisi de farklı cacheleri var. Aynı nesneyi getiriyorlar ama farklı instance
        numarasını kullanıyorlar, birbirinden bağımsız çalışıyorlar. Sonuç olarak, cache uygulama bazında değil entity
        bazında çalışıyor. Buna 'First Leve Cache' deniyor.

         */

    }
}
