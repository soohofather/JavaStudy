package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constratintAnnotation) {

        this.pattern = constratintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext Context) {

        var reValue = value + "01";
        var rePattern = pattern + "dd";

        try{
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}