package tn.esprit.foyer.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniversite;
    String nomUniversite;
    String adresse;
    TypeChambre typeChambre;
    @OneToOne(mappedBy = "universite")
    Foyer foyer;
}
