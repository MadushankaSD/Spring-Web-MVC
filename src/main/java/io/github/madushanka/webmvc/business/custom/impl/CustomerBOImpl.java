package io.github.madushanka.webmvc.business.custom.impl;

import io.github.madushanka.webmvc.business.custom.CustomerBO;
import io.github.madushanka.webmvc.dao.custom.CustomerDAO;
import io.github.madushanka.webmvc.dao.custom.OrderDAO;
import io.github.madushanka.webmvc.dao.custom.OrderDetailDAO;
import io.github.madushanka.webmvc.dto.CustomerDTO;
import io.github.madushanka.webmvc.dto.ItemDTO;
import io.github.madushanka.webmvc.entity.Customer;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void saveCustomer(CustomerDTO customer)  {
            customerDAO.save(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public void updateCustomer(CustomerDTO customer)  {
            customerDAO.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public void deleteCustomer(String customerId)  {

            if (orderDAO.existsByCustomerId(customerId)) {
                new Alert(Alert.AlertType.WARNING,"This customer Has Already a Order", ButtonType.OK).show();

            }else {
                customerDAO.delete(customerId);
            }
    }

    @Override
    public List<CustomerDTO> findAllCustomers()  {
            List<Customer> alCustomers = customerDAO.findAll();

            List<CustomerDTO> dtos = new ArrayList<>();
            for (Customer customer : alCustomers) {
                dtos.add(new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getAddress()));
            }
            return dtos;

    }

    @Override
    public String getLastCustomerId()  {
            String lastCustomerId = customerDAO.getLastCustomerId();
            return lastCustomerId;

    }

    @Override
    public CustomerDTO findCustomer(String customerId)  {
            Customer customer = customerDAO.find(customerId);
        return customer!=null?new CustomerDTO(customer.getCustomerId(),
                customer.getName(), customer.getAddress()):null;
    }

    @Override
    public List<String> getAllCustomerIDs()  {
            List<Customer> customers = customerDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Customer customer : customers) {
                ids.add(customer.getCustomerId());
            }
            return ids;
    }
}
