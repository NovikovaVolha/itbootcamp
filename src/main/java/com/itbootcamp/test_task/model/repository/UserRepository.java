package com.itbootcamp.test_task.model.repository;

import com.itbootcamp.test_task.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUsersBySurnameContainingIgnoreCase(String surname);

    List<User> findUsersByNameContainingIgnoreCase(String name);

    List<User> findUsersByPatronymicContainingIgnoreCase(String patronymic);

    List<User> findUsersBySurnameAndNameIgnoreCase(String surname, String name);

    User findUserByEmail(String email);

}
