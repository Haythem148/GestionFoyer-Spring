package tn.esprit.foyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;
    @Enumerated(EnumType.STRING)
            TypeChambre typeChambre;
    Long numChambre;
    @ManyToOne
    Bloc bloc;
    @OneToMany
    Set<Reservation>reservations;

}
