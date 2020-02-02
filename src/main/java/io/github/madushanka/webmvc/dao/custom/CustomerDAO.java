package io.github.madushanka.webmvc.dao.custom;

import io.github.madushanka.webmvc.dao.CrudDAO;
import io.github.madushanka.webmvc.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer, String> {

    String getLastCustomerId() ;

}
