package io.github.madushanka.webmvc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping("api/v1/customers?")
//@RequestMapping("api/v1/c*")
//@RequestMapping("api/v1/**")
@RequestMapping("api/v1/customers")
public class CustomerController {

    @GetMapping
    public String getSomething(){
        return "get all test";
    }
    @PostMapping
    public String postSomething(){
        return "post test";
    }
    @DeleteMapping("/{id}")
    public String deleteSomething(@PathVariable String id){
        System.out.println(id);
        return "delete test"+id;
    }
    @PutMapping("/{id}")
    public String putSomething(@PathVariable String id){
        return "put test"+ id;
    }
    @GetMapping("/{id}")
    public String getOneSomething(@PathVariable String id){
        return "get one test"+id;
    }
}
