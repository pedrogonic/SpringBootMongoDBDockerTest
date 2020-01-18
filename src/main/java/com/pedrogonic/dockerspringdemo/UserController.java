package com.pedrogonic.dockerspringdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrikaMapper orikaMapper;

    @GetMapping
    public List<WebsiteUserDTO> findAll() {

        List<WebsiteUser> list = userService.findAll();

        return orikaMapper.mapAsList(list, WebsiteUserDTO.class);

    }

}
