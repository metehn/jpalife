package cache.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable()
public class Frequent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long frequentId;
    private String frequentName;

}
