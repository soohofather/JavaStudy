package com.example.springboot_filter.controller;

import com.example.springboot_filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}", userRequest);
        return userRequest;
    }
}
