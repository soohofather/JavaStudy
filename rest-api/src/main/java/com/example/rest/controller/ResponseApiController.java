package com.example.rest.controller;

import com.example.rest.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    // /api/v1
    @GetMapping("")
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserNumber(10);
        user.setUserEmail("hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-custum", "hi")
                .body(user);

        return response;
    }
}
