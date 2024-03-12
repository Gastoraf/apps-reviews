package ru.lab.reviews.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ReviewsServiceImpl implements ReviewsService {

    private final WebClient webClient;

    @Autowired
    public ReviewsServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @Override
    public void add(Review review) {
        webClient.post()
                .uri("/reviews/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(review))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public void remove(Review review) {
        webClient.post()
                .uri("/reviews/remove")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(review))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public void removeAllByUserId(Long userId) {
        webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/reviews/removeAll")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public List<Review> listByUserId(Long userId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/reviews")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .bodyToFlux(Review.class)
                .collectList()
                .block();
    }

    @Override
    public List<Review> listByAppId(Long appId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/reviews")
                        .queryParam("appId", appId)
                        .build())
                .retrieve()
                .bodyToFlux(Review.class)
                .collectList()
                .block();
    }
}
