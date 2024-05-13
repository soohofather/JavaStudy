package com.example.httpheader.controller;

import com.example.httpheader.db.UserRepository;
import com.example.httpheader.model.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
        HttpServletRequest httpServletRequest,

        @CookieValue(name = "authorization-cookie", required = false)
        String authorizationCookie
    ) {
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findById(authorizationCookie);

        return optionalUserDto.get();

//        var cookies = httpServletRequest.getCookies();
//
//        if(cookies != null){
//
//            for(Cookie cookie: cookies){
//
//                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
//
//            }
//        }

//        return null;
    }

    @GetMapping("/me2")
    public UserDto me2(
            @RequestHeader(name = "authorization", required = false)
            String authorizationHeader
    ) {
        log.info("authorizationCookie : {}", authorizationHeader);
        var optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}
