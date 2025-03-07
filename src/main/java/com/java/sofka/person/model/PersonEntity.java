package com.java.sofka.person.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "NAME", nullable = false, length = 128)
    private String name;

    @Column(name = "GENDER", length = 16)
    private String gender;

    @Column(name = "AGE")
    private Short age;

    @Column(name = "IDENTIFICATION", nullable = false, unique = true, length = 13)
    private String identification;

    @Column(name = "ADDRESS", length = 512)
    private String address;

    @Column(name = "PHONE", length = 16)
    private String phone;

//    @OneToOne(mappedBy = "personEntity")
//    private ClientEntity clientEntity;
}
