package ru.lab.apps.service.service;

import ru.lab.apps.service.entity.App;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface AppsService {
    @WebMethod
    List<App> getAllApps();

    @WebMethod
    void addApp(App product);

    @WebMethod
    App getAppById(Long id);

}
