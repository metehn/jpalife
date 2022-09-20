package listen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@EntityListeners( { LivingListener.class } )
public class Living {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long livingId;
    private String firstName;
    private String lastName;
    private boolean emptyName;

    @PrePersist
    public void onPrePersist(){ // persist etmeden önce bu methodu çağır
        System.out.println("onPrePersist()");
        if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()){
            emptyName = true;

        }else{
            emptyName = false;
        }

    }




}
