package ru.lab.reviews.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long appId;
    private int rating;
    private String content;
}
