package com.khaled_GmbH.e.commerce.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "PLZ")
    private String PLZ;
    @Column(name = "city")
    private String city;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;

}
