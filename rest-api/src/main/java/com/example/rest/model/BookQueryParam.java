package com.example.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.PrivateKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParam {

    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}