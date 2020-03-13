package com.xinbo.cloud.service.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
}
