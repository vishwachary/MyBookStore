package org.example.mybookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBooksHomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // maps to index.html
    }
}
