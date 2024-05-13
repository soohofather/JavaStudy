package com.example.httpheader.controller;

import com.example.httpheader.model.LoginRequest;
import com.example.httpheader.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse

    ) {
            return userService.login(loginRequest, httpServletResponse);

    }
}
