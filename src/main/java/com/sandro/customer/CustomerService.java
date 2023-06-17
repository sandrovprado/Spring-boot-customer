package com.sandro.customer;

import org.springframework.stereotype.Service;

import java.util.List;

//Business layer (Class where exceptions are thrown/ex: email is already registered)
@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers(); //from customerDao interface
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("customer with id [%s] not found".formatted(id)));
    }
}
