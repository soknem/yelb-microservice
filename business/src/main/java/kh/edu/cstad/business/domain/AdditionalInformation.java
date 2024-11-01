package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Data;

@Data
@Entity
@Table(name = "additional-informations")
public class AdditionalInformation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
