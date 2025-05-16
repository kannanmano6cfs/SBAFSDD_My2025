package com.learning.excontainerdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {

    @GetMapping("/")
    public String greet() {
        return "Hello World!! I am running from Container in Docker Desktop";
    }
}
