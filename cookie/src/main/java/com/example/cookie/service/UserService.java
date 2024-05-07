package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // login logic
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)){

                // Cookie에 해당 정보 저장
                var cookie = new Cookie("authorization-cookie",userDto.getId());
                cookie.setDomain("localhost"); // naver.com, daun.net (지정된 도메인에서만 사용가능, www는 빼고 입력)
                cookie.setPath("/");
                cookie.setMaxAge(-1); // session과 동일, -1 session이 유지되는 동안


                httpServletResponse.addCookie(cookie);

            }else{
                throw  new RuntimeException("Password Not Match");
            }

        }else{
            //없는 유저
            throw new RuntimeException("User Not Found");
        }
    }
}
