package com.itbootcamp.test_task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbootcamp.test_task.dto.UserDto;
import com.itbootcamp.test_task.dto.enums.RoleDto;
import com.itbootcamp.test_task.exception.UserNotFoundException;
import com.itbootcamp.test_task.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final String END_POINT_PATH = "/users";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    private UserDto user;

    @BeforeEach
    void setup() {
        user = new UserDto(1, "surname", "name", "patronymic", "email@mail.ru", Collections.singletonList(RoleDto.ADMINISTRATOR));
    }

    @Test
    void create_shouldReturnIsCreated_thenCorrect() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(END_POINT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user));
        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void getById_shouldReturnOk_thenCorrect() throws Exception {
        Integer id = 1;
        String requestURI = END_POINT_PATH + "/" + id;

        when(userService.findById(id)).thenReturn(user);

        mockMvc.perform(get(requestURI))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print());
    }

    @Test
    void getById_shouldReturnNotFoundIfWrongId_thenCorrect() throws Exception {
        Integer id = 1;
        String requestURI = END_POINT_PATH + "/" + id;

        when(userService.findById(id)).thenThrow(UserNotFoundException.class);

        mockMvc.perform(get(requestURI))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void delete_shouldReturnNoContent_thenCorrect() throws Exception {
        Integer id = 1;
        String requestURI = END_POINT_PATH + "/" + id;

        doNothing().when(userService).delete(id);

        mockMvc.perform(delete(requestURI))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void delete_shouldReturnNotFoundIfWrongId_thenCorrect() throws Exception {
        Integer id = 1;
        String requestURI = END_POINT_PATH + "/" + id;

        doThrow(UserNotFoundException.class).when(userService).delete(id);

        mockMvc.perform(delete(requestURI))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}
