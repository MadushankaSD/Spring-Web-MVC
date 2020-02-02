package io.github.madushanka.webmvc.dao.custom;


import io.github.madushanka.webmvc.dao.CrudDAO;
import io.github.madushanka.webmvc.entity.Order;

public interface OrderDAO extends CrudDAO<Order, Integer> {

    int getLastOrderId() throws Exception;

    boolean existsByCustomerId(String customerId) throws Exception;

}
