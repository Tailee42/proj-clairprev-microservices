package com.urbanisation_si.microservices_contrat_mongodb.modele;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "numeroContrat"})
@ToString(of = {"id", "numeroContrat", "dateDebut", "numeroAssure", "numeroProduit"})
@Document(collection = "gestionprevdb")
public class Contrat {
    @Id
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    @NotNull
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private Long numeroContrat;
    @NotNull
    private Long numeroAssure;
    @NotNull
    private Long numeroProduit;
    private StatusContrat statusContrat;

}
