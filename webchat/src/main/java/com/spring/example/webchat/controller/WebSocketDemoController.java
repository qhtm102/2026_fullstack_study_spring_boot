package com.spring.example.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "demo")
public class WebSocketDemoController {

    @GetMapping(path = "/echo-test")
    public String echoTestForm() {

        return "demo/echo-test";
    }
}
