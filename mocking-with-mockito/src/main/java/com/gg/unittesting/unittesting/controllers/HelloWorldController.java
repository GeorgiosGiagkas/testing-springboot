package com.gg.unittesting.unittesting.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value="/hello-world")
    public String helloWorld(){
        return "Hello world";
    }
}
