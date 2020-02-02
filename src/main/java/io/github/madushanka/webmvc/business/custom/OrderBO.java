package io.github.madushanka.webmvc.business.custom;

import io.github.madushanka.webmvc.business.SuperBO;
import io.github.madushanka.webmvc.dto.OrderDTO;
import io.github.madushanka.webmvc.dto.OrderDTO2;

import java.util.List;

public interface OrderBO extends SuperBO {

    int getLastOrderId();

    void placeOrder(OrderDTO orderDTO);

    List<OrderDTO2> getOrderInfo();

}
