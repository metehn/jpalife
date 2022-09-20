package listen.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners( { HeritageListener.class } )
public class Mother {

    private String nameField;

    @PrePersist
    public void onPrePersist(){
        System.out.println("Dinleme öncesi...");
    }

}
