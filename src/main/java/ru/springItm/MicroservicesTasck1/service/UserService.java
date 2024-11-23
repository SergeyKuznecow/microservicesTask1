package ru.springItm.MicroservicesTasck1.service;

import ru.springItm.MicroservicesTasck1.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User getById(int id);

    void update(User user,int id);

    void delete(int id);
}
