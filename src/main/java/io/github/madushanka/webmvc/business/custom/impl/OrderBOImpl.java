package io.github.madushanka.webmvc.business.custom.impl;

import io.github.madushanka.webmvc.business.custom.OrderBO;
import io.github.madushanka.webmvc.dao.custom.*;
import io.github.madushanka.webmvc.dto.OrderDTO;
import io.github.madushanka.webmvc.dto.OrderDTO2;
import io.github.madushanka.webmvc.dto.OrderDetailDTO;
import io.github.madushanka.webmvc.entity.CustomEntity;
import io.github.madushanka.webmvc.entity.Item;
import io.github.madushanka.webmvc.entity.Order;
import io.github.madushanka.webmvc.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class OrderBOImpl implements OrderBO {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private QueryDAO queryDAO;
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public int getLastOrderId()  {

            int lastOrderId = orderDAO.getLastOrderId();

            return lastOrderId;


    }

    @Override
    public void placeOrder(OrderDTO order)  {

            int oId = order.getId();
            orderDAO.save(new Order(oId, new java.sql.Date(new Date().getTime()),customerDAO.find(order.getCustomerId())));

            for (OrderDetailDTO orderDetail : order.getOrderDetails()) {
                orderDetailDAO.save(new OrderDetail(oId, orderDetail.getCode(),
                        orderDetail.getQty(), orderDetail.getUnitPrice()));

                Item item = itemDAO.find(orderDetail.getCode());
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                itemDAO.update(item);

        }
    }

    @Override
    public List<OrderDTO2> getOrderInfo()  {

            List<CustomEntity> ordersInfo = queryDAO.getOrderInfo();
            List<OrderDTO2> dtos = new ArrayList<>();
            for (CustomEntity info : ordersInfo) {
                dtos.add(new OrderDTO2(info.getOrderId(),
                        info.getOrderDate(),info.getCustomerId(),info.getCustomerName(),info.getOrderTotal()));
            }

            return dtos;
        }

}
