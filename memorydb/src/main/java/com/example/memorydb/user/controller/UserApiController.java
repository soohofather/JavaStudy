package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(
        @PathVariable Long id
    ){
       // userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterscore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/min-max")
    public List<UserEntity> filterscore(
            @RequestParam int min,
            @RequestParam int max

    ){
        return userService.filterScore(min, max);
    }

    @GetMapping("/min2-max2")
    public List<UserEntity> filterscore2(
            @RequestParam int min2,
            @RequestParam int max2

    ){
        return userService.filterScore2(min2, max2);
    }


}
