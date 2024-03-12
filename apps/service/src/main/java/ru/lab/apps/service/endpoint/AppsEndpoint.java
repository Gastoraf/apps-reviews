package ru.lab.apps.service.endpoint;

import ru.lab.apps.service.service.AppsService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppsEndpoint {

    private final AppsService service;
    private final Bus bus;

    @Autowired
    public AppsEndpoint(Bus bus, AppsService service) {
        this.bus = bus;
        this.service = service;
    }

    @Bean(name = "apps-endpoint")
    public Endpoint getAppsEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/apps");
        return endpoint;
    }

}