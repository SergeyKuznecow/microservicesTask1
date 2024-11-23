package ru.springItm.MicroservicesTasck1.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.springItm.MicroservicesTasck1.model.User;
import ru.springItm.MicroservicesTasck1.repositories.UserRepositories;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public List<User> getUsers() {
        return userRepositories.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        // Проверка на наличие обязательных полей
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        userRepositories.save(user);
    }

    @Override
    public User getById(int id) {
        Optional<User> optional = userRepositories.findById(id);
        return optional.orElse(null);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        // Проверка на наличие обязательных полей
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        // Проверка существования пользователя
        User existingUser = getById(id);
        if (existingUser == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }

        // Обновление данных пользователя
        existingUser.setUsername(user.getUsername());
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());

        userRepositories.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepositories.deleteById(id);
    }
}