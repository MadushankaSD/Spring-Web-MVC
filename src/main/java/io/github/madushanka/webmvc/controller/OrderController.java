package io.github.madushanka.webmvc.controller;

import io.github.madushanka.webmvc.business.custom.OrderBO;
import io.github.madushanka.webmvc.dto.OrderDTO;
import io.github.madushanka.webmvc.dto.OrderDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderBO orderBO;

    @GetMapping(params = {"last"})
    public int getLastOrderId(){
       return orderBO.getLastOrderId();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void placeOrder(@RequestBody OrderDTO order){
        orderBO.placeOrder(order);
    }

    @GetMapping
    public List<OrderDTO2> getOrderInfo(){
        return orderBO.getOrderInfo();
    }
}
