package com.ijse.cmjd.posSystemBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String username;

    @Column(unique=true)
   // @Email(message="*Please provide a valid Email")
    private String email;


    private String password;


}
