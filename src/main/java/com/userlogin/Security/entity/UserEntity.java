package com.userlogin.Security.entity;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
}

