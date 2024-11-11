package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 10)
    private String iso;

    @Column(unique = true, nullable = false, length = 10)
    private String iso3;

    @Column(unique = true, nullable = false, length = 10)
    private Integer numCode;

    @Column(unique = true, nullable = false, length = 10)
    private Integer phoneCode;

    @Column(unique = true, nullable = false, length = 60)
    private String name;

    private String niceName;

    private String flag;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

}