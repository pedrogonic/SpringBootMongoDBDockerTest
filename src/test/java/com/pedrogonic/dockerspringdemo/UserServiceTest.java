package com.pedrogonic.dockerspringdemo;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    WebsiteUser websiteUser;

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

        given(userRepository.findAll()).willReturn(users);
    }

    @Test
    void findAll() {

        List<WebsiteUser> foundUsers = userService.findAll();

        verify(userRepository).findAll();

        assertEquals(1, foundUsers.size());

    }
}