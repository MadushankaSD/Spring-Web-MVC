package io.github.madushanka.webmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
public class MyController {

    public String doSometing(){
        return "Hello WebMVC";
    }

}
