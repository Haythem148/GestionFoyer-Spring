package tn.esprit.foyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;
    Date anneeUniversite;
    Boolean estValide;
    @ManyToMany(mappedBy = "reservations")
    Set<Etudiant>etudiants;
}
