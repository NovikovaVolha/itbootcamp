package com.itbootcamp.test_task.service.impl;

import com.itbootcamp.test_task.dto.UserDto;
import com.itbootcamp.test_task.dto.UserInfoDto;
import com.itbootcamp.test_task.exception.UserNotFoundException;
import com.itbootcamp.test_task.mapper.UserMapper;
import com.itbootcamp.test_task.mapper.enums.RoleMapper;
import com.itbootcamp.test_task.model.entity.User;
import com.itbootcamp.test_task.model.repository.UserRepository;
import com.itbootcamp.test_task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public void save(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public Page<UserInfoDto> findAllPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 10, Sort.Direction.ASC, "email");
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toUserInfoDto);
    }

    @Override
    public UserDto findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.toDto(user.get());
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public void update(Integer id, UserDto user) {
        User userFromDB = userRepository.getReferenceById(id);

        userFromDB.setSurname(user.getSurname());
        userFromDB.setName(user.getName());
        userFromDB.setPatronymic(user.getPatronymic());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setRoles(roleMapper.toEntityList(user.getRoles()));

        userRepository.save(userFromDB);
    }

    @Override
    public void delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

}
