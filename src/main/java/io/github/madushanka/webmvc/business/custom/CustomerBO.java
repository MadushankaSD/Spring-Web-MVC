package io.github.madushanka.webmvc.business.custom;

import io.github.madushanka.webmvc.business.SuperBO;
import io.github.madushanka.webmvc.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {

    void saveCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    void deleteCustomer(String customerId);

    List<CustomerDTO> findAllCustomers() ;

    String getLastCustomerId();

    CustomerDTO findCustomer(String customerId) ;

    List<String> getAllCustomerIDs();

}
