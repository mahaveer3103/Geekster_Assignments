package com.geekster.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "name")
    private String name;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
