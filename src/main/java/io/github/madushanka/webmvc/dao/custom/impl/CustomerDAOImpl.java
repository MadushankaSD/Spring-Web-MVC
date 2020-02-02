package io.github.madushanka.webmvc.dao.custom.impl;


import io.github.madushanka.webmvc.dao.CrudDAOImpl;
import io.github.madushanka.webmvc.dao.custom.CustomerDAO;
import io.github.madushanka.webmvc.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl extends CrudDAOImpl<Customer,String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
       return (String) getSession().createNativeQuery("SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1").uniqueResult();
    }
}
