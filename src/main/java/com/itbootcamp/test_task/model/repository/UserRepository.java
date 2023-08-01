package com.itbootcamp.test_task.model.repository;

import com.itbootcamp.test_task.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
