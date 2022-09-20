package listen.entity;

import jakarta.persistence.PostPersist;

public class LivingListener {

    @PostPersist
    public void onPostPersist(Living living){

        System.out.println("Varlık dinleniyor..." + living.getLivingId());

    }
}
