package cache.test;

import cache.entity.Frequent;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SecondLevelFind {

    public static void main(String[] args) {

        /*

        Avantajı dezavantajı

        *Her zaman çalışmayabilir. Ekstra ayar gerektirebilir.

         */

        /*
        persistence.xml

            <shared-cache-mode>ALL</shared-cache-mode> //hepsini cacheler

            <shared-cache-mode>NONE</shared-cache-mode> //hiç birini cachelemez

            <shared-cache-mode>ENABLE_SELECTIVE</shared-cache-mode> //@Cacheable(ture) olanları cachele

            <shared-cache-mode>DISABLE_SELECTIVE</shared-cache-mode> //@Cacheable(false) olanları cacheleme, diğer her şeyi cachele

         */

        long frequentId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LifePersistenceUnit");

        Cache cache = factory.getCache();

        EntityManager entityManager = factory.createEntityManager();

        Frequent frequent = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent);
        System.out.println("Cachede mi: " + cache.contains(Frequent.class, frequentId)); // Frequent sınıfının , frequentId'li nesnesi cachede mi onu görebiliriz.

        cache.evict(Frequent.class, frequentId); // Global cachedeki frequentId li nesneyi boşalt.
        // cache.evict(Frequent.class); Frequent nesnelerinin turundeki nesnelerin hepsini cacheden boşalt.
        //cache.evictAll(); Bütün cacheyi boşalt.
        entityManager.close();


    }

}
