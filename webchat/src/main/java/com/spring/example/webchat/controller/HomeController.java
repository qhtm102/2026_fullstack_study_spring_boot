package com.spring.example.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = {"/", "/home"})
    public String home() {
        return "home";
    }
}
