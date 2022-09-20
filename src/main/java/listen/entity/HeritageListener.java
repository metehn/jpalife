package listen.entity;

import jakarta.persistence.PostPersist;

public class HeritageListener {

    @PostPersist
    public void onPostPersist(Mother mother){
        System.out.println("Dinleme sonrası...");
    }

}
