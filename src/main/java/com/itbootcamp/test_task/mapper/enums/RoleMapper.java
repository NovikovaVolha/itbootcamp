package com.itbootcamp.test_task.mapper.enums;

import com.itbootcamp.test_task.dto.enums.RoleDto;
import com.itbootcamp.test_task.model.entity.enums.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    List<RoleDto> toDtoList(List<Role> roles);

    List<Role> toEntityList(List<RoleDto> roles);

}
