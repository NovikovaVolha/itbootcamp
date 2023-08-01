package com.itbootcamp.test_task.dto;

import com.itbootcamp.test_task.model.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private String fio;
    private String email;
    private List<Role> roles;

}
