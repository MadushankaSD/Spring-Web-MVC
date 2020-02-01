package io.github.madushanka.webmvc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/hello")
public class MyController {

    @GetMapping
    public String doSometing(){
        return "Hello WebMVC";
    }

}
