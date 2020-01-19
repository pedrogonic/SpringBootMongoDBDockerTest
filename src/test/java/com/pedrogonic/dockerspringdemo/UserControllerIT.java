package com.pedrogonic.dockerspringdemo;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    UserService userService;

    @MockBean
    OrikaMapper orikaMapper;

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
    void findAll() {

        String url = "/api/users";

        List<WebsiteUserDTO> returnUsers = testRestTemplate.getForObject(url, List.class);

        assertEquals(1, returnUsers.size());

    }
}