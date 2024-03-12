package ru.lab.reviews.client;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private Long userId;
    private Long appId;
    private int rating;
    private String content;
}
