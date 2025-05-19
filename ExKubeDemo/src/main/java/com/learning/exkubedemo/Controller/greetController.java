package com.learning.exkubedemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {

    @GetMapping("/")
    public String greet() {
          return "Hello World!! I am running from Container in Kubernetes";
    }
}
