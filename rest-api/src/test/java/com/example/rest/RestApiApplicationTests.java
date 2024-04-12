package com.example.rest;

import com.example.rest.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserNumber(10);
        user.setUserEmail("hong@gmail.com");
        user.setIsKorean(true);

        var json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        var dto = objectMapper.readValue(json, UserRequest.class);
        System.out.println(dto);
    }

}
