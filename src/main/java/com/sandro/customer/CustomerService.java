package com.sandro.customer;

import com.sandro.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//Business layer (Class where exceptions are thrown/ex: email is already registered)
@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) { //@Qualifier to inject specific data access service
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers(); //from customerDao interface
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        () -> new ResourceNotFound("customer with id [%s] not found".formatted(id)));
    }
}
