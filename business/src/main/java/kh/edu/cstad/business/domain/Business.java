package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.config.jpa.Auditable;
import lombok.Data;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Data
@Entity
@Table(name = "businesses")
public class Business extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String alias;

    @Column(unique = false, nullable = false) // change unique to false, easy to test create business without creating new user
    private String username;    // username of business owner account

    @Column(unique = true, nullable = false, columnDefinition = "TEXT")
    private String brand;

    @Column(unique = true, columnDefinition = "TEXT")
    private String customBrand;

    private String logo;
    private String cover;
    private String thumbnail;

    @Column(columnDefinition = "TEXT")
    private String about;

    @Column(unique = true, nullable = false, length = 30)
    private String phoneNumber;

    @ManyToOne
    private Country country;

    @ManyToOne
    private City city;

    @Column(columnDefinition = "TEXT")
    private String address1;

    @Column(columnDefinition = "TEXT")
    private String address2;

    @Column(columnDefinition = "TEXT")
    private String address3;

    private String stateOrProvince;

    @Column(length = 32)
    private String zipCode;

    private Boolean isOpening24Hours;

    //@Convert(converter = OpeningHourAttributeConverter.class) // old code hibernate older than 6
    @JdbcTypeCode(SqlTypes.JSON) // new code hibernate greater than or equal 6 (Using Hibernate 6’s standard JSON mapping)
    private List<OpeningHour> openingHours;

    //@Convert(converter = AdditionalInformationAttributeConverter.class) // // old code hibernate older than 6
    @JdbcTypeCode(SqlTypes.JSON) // new code hibernate greater than or equal 6 (Using Hibernate 6’s standard JSON mapping)
    private List<AdditionalInformation> additionalInformation;

    @ManyToMany
    @JoinTable(name = "businesses_categories",
            joinColumns = @JoinColumn(name = "business_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories;

    @Column(unique = true, length = 150)
    private String website;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    private Boolean isClaimed;
    private Boolean isClosed;
    private Boolean isApproved;
    private Boolean isSearchable;

    private Double latitude;
    private Double longitude;
    private String googleMap;

    private String price;

    @ManyToMany
    @JoinTable(name = "businesses_transactions",
            joinColumns = @JoinColumn(name = "business_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"))
    private List<Transaction> transactions;
}