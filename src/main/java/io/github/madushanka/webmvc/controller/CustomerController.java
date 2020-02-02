package io.github.madushanka.webmvc.controller;


import io.github.madushanka.webmvc.business.custom.CustomerBO;
import io.github.madushanka.webmvc.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerBO customerBO;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@RequestBody CustomerDTO customer) {
        customerBO.saveCustomer(customer);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable String id) {
        return customerBO.findCustomer(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomer() {
        return customerBO.findAllCustomers();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerBO.deleteCustomer(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestParam String id, @RequestBody CustomerDTO customer) {
        customerBO.updateCustomer(customer);
    }

    @GetMapping(params = {"last"})
    public String getLastCustomerId() {
        return customerBO.getLastCustomerId();
    }

    @GetMapping(params = {"full"})
    public List<String> getAllId() {
        return customerBO.getAllCustomerIDs();
    }

}
