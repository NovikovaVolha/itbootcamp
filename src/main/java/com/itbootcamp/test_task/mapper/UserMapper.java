package com.itbootcamp.test_task.mapper;

import com.itbootcamp.test_task.dto.UserDto;
import com.itbootcamp.test_task.dto.UserInfoDto;
import com.itbootcamp.test_task.mapper.enums.RoleMapper;
import com.itbootcamp.test_task.model.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> users);

    default UserInfoDto toUserInfoDto(User user) {
        return UserInfoDto.builder()
                .fio(user.getSurname() + " " + user.getName() + " " + user.getPatronymic())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    List<UserInfoDto> toUserInfoDtoList(List<User> users);

}
