package io.github.madushanka.webmvc.controller;


import io.github.madushanka.webmvc.business.custom.CustomerBO;
import io.github.madushanka.webmvc.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerBO customerBO;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@RequestBody CustomerDTO customer) {
        customerBO.saveCustomer(customer);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String id) {
        CustomerDTO customer = customerBO.findCustomer(id);
        if(customer!=null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        List<CustomerDTO> allCustomers = customerBO.findAllCustomers();
        HttpHeaders httpHeaders = new HttpHeaders();
        System.out.println(allCustomers.size());
        httpHeaders.add("X-Count",allCustomers.size()+"");
        return new ResponseEntity<>(allCustomers,httpHeaders,HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerBO.deleteCustomer(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestBody CustomerDTO customer) {
        customerBO.updateCustomer(customer);
    }

    @GetMapping(params = {"last"})
    public String getLastCustomerId() {
        return customerBO.getLastCustomerId();
    }

    @GetMapping(params = {"full"},produces =MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllId() {
        return customerBO.getAllCustomerIDs();
    }

}
