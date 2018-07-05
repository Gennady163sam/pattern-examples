package com.nexign.controllers;

import com.nexign.model.patterns.Singleton;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World";
    }

    @RequestMapping("/patterns/singleton")
    @ResponseBody
    Singleton getSingleton() {
        return Singleton.getInstance();
    }
}
