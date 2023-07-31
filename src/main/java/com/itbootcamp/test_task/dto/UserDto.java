package com.itbootcamp.test_task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itbootcamp.test_task.dto.enums.RoleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonIgnore
    private Integer id;
    @NotBlank(message = "Is required.")
    @Pattern(regexp = "^[a-zA-Z]{1,40}$", message = "Must be from 1 to 40 characters. Latin letters only.")
    private String surname;
    @NotBlank(message = "Is required.")
    @Pattern(regexp = "^[a-zA-Z]{1,20}$", message = "Must be from 1 to 20 characters. Latin letters only.")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]{0,40}$", message = "Must be from 0 to 40 characters. Latin letters only.")
    private String patronymic;
    @Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})){0,50}$",
            message = "Must be from 0 to 50 characters. Several special characters are allowed, " +
                    "including period (.), hyphen (-), underscore (_) and @ sign. Latin letters only.")
    private String email;
    private List<RoleDto> roles;

}
