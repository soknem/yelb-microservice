package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
