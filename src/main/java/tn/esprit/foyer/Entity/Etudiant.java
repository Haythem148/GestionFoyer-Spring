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

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;
    String nomEtudiant;
    String prenomEtudiant;
    Long Cin;
    String ecole;
    Date dateNaissance;
 @ManyToMany
    Set<Reservation>reservations;
}
