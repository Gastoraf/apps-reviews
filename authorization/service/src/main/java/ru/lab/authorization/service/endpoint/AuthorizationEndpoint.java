package ru.lab.authorization.service.endpoint;

import ru.lab.authorization.service.service.AuthorizationService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationEndpoint {

    private final AuthorizationService service;
    private final Bus bus;

    @Autowired
    public AuthorizationEndpoint(Bus bus, AuthorizationService service) {
        this.bus = bus;
        this.service = service;
    }

    @Bean(name = "authorization")
    public Endpoint getAuthorizationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/user");
        return endpoint;
    }

}