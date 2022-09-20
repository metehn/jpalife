package lock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Shared {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sharedId;
    private  String sharedName;

    @Version //entityManager.lock() kullanabilmek için versiyon tanımlamak gerekiyor
    private  long versionNumber;
}
