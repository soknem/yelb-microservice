package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
