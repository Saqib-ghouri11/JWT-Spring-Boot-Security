package com.spring.securityjwt.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/home")
    public String home(){
        return "welcome home.";
    }
}
