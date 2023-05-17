package com.osmanaltunay.questApp.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
