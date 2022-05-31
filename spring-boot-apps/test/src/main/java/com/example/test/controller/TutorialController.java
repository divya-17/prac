package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @GetMapping("/")
    public String home(){
        System.out.println("Starting spring web app");
        return "home";
    }
}
