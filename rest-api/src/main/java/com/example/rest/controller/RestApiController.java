package com.example.rest.controller;

import com.example.rest.model.BookQueryParam;
import com.example.rest.model.BookQueryParam2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
     public String hello() {
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

         return html;
     }

     @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
     public String echo(
             @PathVariable(name = "message") String msg,
             @PathVariable int age,
             @PathVariable boolean isMan

     ) {
         System.out.println("echo message : "+msg);
         System.out.println("echo age : "+age);
         System.out.println("echo isMan : "+isMan);


         String big = msg + 62;

         return msg.toUpperCase();
     }

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받습니다. int 형태로 받아서 두 수익 덧셈, 곰셈

    @GetMapping(path = "/todo")
    public void queryParamTodo(
            BookQueryParam2 bookQueryParam2
    ) {
        int sum;
        sum = bookQueryParam2.getNum1() + bookQueryParam2.getNum2();
        System.out.println(sum);
    }

    @DeleteMapping(path = {"/user/{userName}/delete", "/del"})
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }

}
