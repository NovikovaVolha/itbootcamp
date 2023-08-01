package com.itbootcamp.test_task.service;

import com.itbootcamp.test_task.dto.UserDto;
import com.itbootcamp.test_task.dto.UserInfoDto;
import org.springframework.data.domain.Page;

public interface UserService {

    void save(UserDto user);

    Page<UserInfoDto> findAllPaginated(Integer page);

    UserDto findById(Integer id);

    void update(Integer id, UserDto user);

    void delete(Integer id);

}
