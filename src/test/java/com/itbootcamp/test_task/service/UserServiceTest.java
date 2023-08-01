package com.itbootcamp.test_task.service;

import com.itbootcamp.test_task.dto.UserDto;
import com.itbootcamp.test_task.mapper.UserMapper;
import com.itbootcamp.test_task.model.entity.User;
import com.itbootcamp.test_task.model.repository.UserRepository;
import com.itbootcamp.test_task.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static final Integer ID = 1;
    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void save_shouldSaveUser_thenCorrect() {
        UserDto user = mock(UserDto.class);

        userService.save(user);

        verify(userRepository).save(userMapper.toEntity(user));
    }

    //@Test
    void findById_shouldReturnUser_thenCorrect() {
        User expected = mock(User.class);
        when(userRepository.findById(ID)).thenReturn(Optional.of(expected));

        UserDto actual = userService.findById(ID);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
        verify(userRepository).findById(ID);
    }

    @Test
    void delete_shouldDeleteUser_thenCorrect() {
        User expected = mock(User.class);
        when(userRepository.findById(ID)).thenReturn(Optional.of(expected));

        userService.delete(ID);

        verify(userRepository).deleteById(ID);
    }

}
