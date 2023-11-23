package tn.esprit.foyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String idReservation;
    LocalDate anneeUniversite;
    Boolean estValide;
    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;
}
