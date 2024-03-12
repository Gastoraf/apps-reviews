package ru.lab.apps.service.service;

import jakarta.jws.WebService;
import ru.lab.apps.service.entity.App;
import ru.lab.apps.service.repository.AppsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@WebService(serviceName = "WebServiceApps", portName = "AppsPort", targetNamespace = "https://apps.lab.ru")
public class AppsServiceImpl implements AppsService {

    private final AppsRepository repository;

    @Autowired
    public AppsServiceImpl(AppsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<App> getAllApps() {
        return repository.findAll();
    }

    @Override
    public void addApp(App product) {
        repository.save(product);
    }

    @Override
    public App getAppById(Long id) {
        return repository.findById(id).orElse(null);
    }

}