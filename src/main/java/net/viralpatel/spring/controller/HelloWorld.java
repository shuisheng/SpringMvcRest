package net.viralpatel.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sun.misc.Contended;

@Controller
public class HelloWorld {
    @GetMapping("/hello")
    public String HelloWorld() {
        return "index";
    }
}
