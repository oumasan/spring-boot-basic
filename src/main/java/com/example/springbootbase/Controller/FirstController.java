package com.example.springbootbase.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FirstController {
    @GetMapping("/")
    public String getHelloStrings() {
        return "Hello";
    }
}