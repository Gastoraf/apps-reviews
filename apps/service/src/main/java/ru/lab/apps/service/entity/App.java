package ru.lab.apps.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String marketplace;
    private String description;
}
