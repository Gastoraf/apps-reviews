package ru.lab.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ru.lab")
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}