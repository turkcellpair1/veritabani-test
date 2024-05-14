package com.yk.crm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costumer_id")
    private int costumerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nationality_id")
    private int nationalityId;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "gender")
    private String gender;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private Login login;

    @OneToOne()
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

}
