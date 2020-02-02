package io.github.madushanka.webmvc.dao.custom.impl;


import io.github.madushanka.webmvc.dao.CrudDAOImpl;
import io.github.madushanka.webmvc.dao.custom.OrderDAO;
import io.github.madushanka.webmvc.entity.Order;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order,Integer> implements OrderDAO {

    @Override
    public int getLastOrderId()  {
        Object object = getSession().createNativeQuery("SELECT id FROM `order` ORDER BY id DESC LIMIT 1").uniqueResult();
        return object==null?0: (int) object;
    }

    @Override
    public boolean existsByCustomerId(String customerId)  {
        NativeQuery nativeQuery = getSession().createNativeQuery("SELECT * FROM `order` WHERE customerId=? LIMIT 1");
        nativeQuery.setParameter(1, customerId);

        return nativeQuery.uniqueResult()!=null;

    }
}
