package com.itbootcamp.test_task.dto;

import com.itbootcamp.test_task.dto.enums.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserToUpdateDto {

    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private List<RoleDto> roles;

}
