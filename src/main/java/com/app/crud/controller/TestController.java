package com.app.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/test")
@Controller
public class TestController {

    @GetMapping("/tm")
    public String test(Model modelo){
        return "tm.html";
    }

}



