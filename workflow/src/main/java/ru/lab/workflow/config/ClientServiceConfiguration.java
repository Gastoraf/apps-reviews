package ru.lab.workflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.lab.apps.client.AppsService;
import ru.lab.apps.client.WebServiceApps;
import ru.lab.authorization.client.AuthorizationService;
import ru.lab.authorization.client.WebServiceAuthorization;

@Configuration
public class ClientServiceConfiguration {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public AuthorizationService getUserService() {
        WebServiceAuthorization service = new WebServiceAuthorization();
        return service.getAuthorizationPort();
    }

    @Bean
    public AppsService getProductService() {
        WebServiceApps service = new WebServiceApps();
        return service.getAppsPort();
    }
}
