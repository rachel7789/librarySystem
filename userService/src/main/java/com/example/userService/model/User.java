package com.example.userService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
//import jakarta.validation.constraints.Pattern;


@Entity
@Data
public class User {

    @Id
    @Column(length = 9, unique = true)
//    @Pattern(regexp = "\\d{9}", message = "ID must be exactly 9 digits")
    private String id; // ת"ז

    private String name;
//    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
//    @Column(length = 10)
    private String phone;
    private String address;
}
