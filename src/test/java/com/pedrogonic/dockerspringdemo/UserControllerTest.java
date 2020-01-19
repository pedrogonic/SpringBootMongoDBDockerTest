package com.pedrogonic.dockerspringdemo;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    UserService userService;

    @MockBean
    OrikaMapper orikaMapper;

    @Autowired
    MockMvc mockMvc;

    WebsiteUser websiteUser;
    WebsiteUserDTO websiteUserDTO;

    @BeforeEach
    void setUp() {
        List<WebsiteUser> users = new ArrayList<>();
        ObjectId id = ObjectId.get();
        websiteUser = WebsiteUser.builder()
                            .id(id)
                            .name("Pedro")
                            .nickname("Pedrinho")
                            .email("")
                            .build();
        users.add(websiteUser);

        List<WebsiteUserDTO> userDTOs = new ArrayList<>();
        websiteUserDTO = WebsiteUserDTO.builder()
                .id(id.toString())
                .name("Pedro")
                .nickname("Pedrinho")
                .email("")
                .build();
        userDTOs.add(websiteUserDTO);

        given(userService.findAll()).willReturn(users);
        given(orikaMapper.mapAsList(users, WebsiteUserDTO.class)).willReturn(userDTOs);
    }

    @Test
    void findAll() throws Exception {

        mockMvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].id", is(websiteUser.getId().toString())));

    }
}