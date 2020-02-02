package io.github.madushanka.webmvc.controller;

import io.github.madushanka.webmvc.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
//@RequestMapping("api/v1/customers?")
//@RequestMapping("api/v1/c*")
//@RequestMapping("api/v1/**")
@RequestMapping("api/v1/customers")
public class CustomerController {

    @GetMapping
    public String getSomething() {
        return "get all test";
    }

    @PostMapping
    public String postSomething() {
        return "post test";
    }

    @DeleteMapping("/{id}")
    public String deleteSomething(@PathVariable String id) {
        System.out.println(id);
        return "delete test" + id;
    }

    /*@PutMapping("/{id}")
    public String putSomething(@PathVariable String id) {
        return "put test" + id;
    }*/

    /* @GetMapping("/{id}/{name}")
      public String getOneSomething(@PathVariable String id,@PathVariable String name){
          return "get one test"+id+name;
      }*/
   /* @GetMapping("/{id:C(\\d){0,3}}")
    public String getOneSomething(@PathVariable String id){
        return "get one test"+id;
    }*/
    /*@GetMapping(params = {"sort"})
    public String getOneSomething(){
      return "Query String sort";
     }*/
    /* @GetMapping(headers = {"Content-Type=text/html"})
    public String getOneSomething(){
      return "header come";
     }*/
     /*@GetMapping(consumes = {"text/html"},produces = {"application/Json"})
    public String getOneSomething(){
      return "header come 2";
     }*/
    /*@GetMapping(params = {"sort"})
    public String getOneSomething(@RequestParam String sort) {
        //request param anotation eka bhavitha karanna pluwan neti unath nama = nam inject karanawa
        return "get Query String";
    }*/
    /*@GetMapping(params = {"name","address","telephone"})
    public String getOneSomething(@RequestParam MultiValueMap<String, List<String>> params) {
        String s = params.toString();
        System.out.println(s);
        return s;
    }*/
    /*@GetMapping(params = {"name","address","telephone"})
    public String getOneSomething(@RequestParam MultiValueMap<String, ArrayList<String>> params) {
        String s = params.toString();
        System.out.println(s);
        return s;
    }*/
    /*@GetMapping(params = {"name","address","telephone"})
    public String getOneSomething(@RequestParam MultiValueMap<String, List<String>> params) {
        String s = params.toString();
        System.out.println(s);
        return s;
    }*/

    /*///////////////////////////////////////////////////////////
                   Query string data Convert to java Object
     ///////////////////////////////////////////////////////// */

    @GetMapping(params = {"id","name","address"})
    public String getOneSomething(@ModelAttribute CustomerDTO customer) {
        String s = customer.toString();
        System.out.println(s);
        return s;
    }

    /*///////////////////////////////////////////////////////////
      Data comes Body From Front End XWW FROM URL ENCODED  VALIN
     ///////////////////////////////////////////////////////// */

/* (1) XWW R encoded waladi enne Query string ekak eka nisa eka variable ekakata enne
 api ewana okkoma key values*/
/* (2) meka map ekakata weda karanne ne Multyvalue Map ekakata weda karanava*/
/* (3) Normal map ekakin ganna be multyvalue map ekakin plwan wena wenama wen karala data ganna*/

    /*@PutMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCustomer(@RequestBody String id) {
        return "put test " + id ;
    }*/

    /*@PutMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCustomer(@RequestBody MultiValueMap id) {
        return "put test " + id ;
    }*/

     /*/////////////////////////////////////////////////////////////////
          Data comes Body From Front End Application/Json VALIN
     ///////////////////////////////////////////////////////////////// */

     /* (1) Json walin awoth @RequestBody annotation eka use karala java object ekakata convert karanna pluwan
    @modelAttribute walin meka karanna be*/
     /* (2) Json waladi map ekalata data gannath pluwan @RequestBody bhavitha karala
      * multy value map ekkta be*/
     /* (3) Thani variable ekakata map kaloth body eke okkoma eka string ekak athulata enawa*/

    /*@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer(@RequestBody CustomerDTO value) {
        return "put test with Json DTO " + value ;
    }*/

    /*@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer(@RequestBody Map<String,String> value) {
        return "put test with Json Map " + value ;
    }*/

    /*@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer(@RequestBody String value) {
        return "put test with Json single paramrter " + value ;
    }*/

     /*/////////////////////////////////////////////////////////////////
          Data comes Body From Front End Application/Json VALIN
     ///////////////////////////////////////////////////////////////// */

}
