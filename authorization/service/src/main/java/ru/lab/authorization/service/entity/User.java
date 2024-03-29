package ru.lab.authorization.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String imagePath;
    private Date lastLogin;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;

}
