package tn.esprit.foyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder

public class Reservation {
    @Id
    String idReservation;
    LocalDate anneeUniversite;
    boolean estValide;
    @ManyToMany(mappedBy = "reservations")
    ArrayList<Etudiant> etudiants;
}
