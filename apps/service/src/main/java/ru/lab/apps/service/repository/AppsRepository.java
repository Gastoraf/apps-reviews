package ru.lab.apps.service.repository;

import ru.lab.apps.service.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppsRepository extends JpaRepository<App, Long> {

}
