package com.pedrogonic.dockerspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<WebsiteUser> findAll() {

        return userRepository.findAll();

    }

}
