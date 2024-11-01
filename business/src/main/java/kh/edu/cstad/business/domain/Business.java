package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Data;

@Data
@Entity
@Table(name = "businesses")
public class Business extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    String alias;

    @Column(nullable = false,unique = true)
    String username;

    @Column(nullable = false,unique = true)
    String brand;

    @Column(nullable = false,unique = true)
    String customBrand;

    String logo;
    String cover;
    String thumbnail;

    @Column(columnDefinition = "TEXT")
    String about;

    @Column(nullable = false,unique = true)
    String phoneNumber;



}
