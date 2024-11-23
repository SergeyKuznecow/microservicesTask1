package ru.springItm.MicroservicesTasck1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springItm.MicroservicesTasck1.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}
