package ru.lab.tests;


import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.lab.apps.client.App;
import ru.lab.apps.client.AppsService;
import ru.lab.apps.client.GetAllAppsResponse;
import ru.lab.apps.client.WebServiceApps;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AppsClientTest {

    private static AppsService service;

    @BeforeClass
    public static void setService() {
        WebServiceApps webService = new WebServiceApps();
        service = webService.getAppsPort();
    }

    static class AsyncAppsHandler implements AsyncHandler<GetAllAppsResponse> {
        private GetAllAppsResponse response;

        @Override
        public void handleResponse(Response<GetAllAppsResponse> response) {
            try {
                this.response = response.get(2000, TimeUnit.MILLISECONDS);
            } catch (ExecutionException | TimeoutException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        public GetAllAppsResponse getResponse() {
            return response;
        }
    }

    @Test
    public void addApp() {
        App app = new App();
        app.setName("Приложение 1");
        app.setDescription("Приложения анализа Сбермаркета");
        app.setMarketplace("Сбермаркет");
        service.addApp(app);
        assertFalse(service.getAllApps().isEmpty());
    }

    @Test
    public void getAppById() {
        App app = service.getAppById(1L);
        assertNotNull(app);
    }

    @Test
    public void getAllApps() {
        List<App> products = service.getAllApps();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    public void getAllApps_AsyncMethod1() {
        AsyncAppsHandler asyncHandler = new AsyncAppsHandler();
        Future<?> futureResponse = service.getAllAppsAsync(asyncHandler);
        while (!futureResponse.isDone()) {
            try {
                System.out.println("Method 1. Waiting...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<App> apps = asyncHandler.getResponse().getReturn();
        assertNotNull(apps);
        assertFalse(apps.isEmpty());
    }

    @Test
    public void getAllApps_AsyncMethod2() {
        Response<GetAllAppsResponse> response = service.getAllAppsAsync();

        while (!response.isDone()) {
            try {
                System.out.println("Method 2. Waiting...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            List<App> apps = response.get().getReturn();
            assertNotNull(apps);
            assertFalse(apps.isEmpty());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}