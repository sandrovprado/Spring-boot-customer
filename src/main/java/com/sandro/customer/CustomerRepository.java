package com.sandro.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> { //Integer refers to Customer id

    boolean existsCustomersByEmail(String email);
    boolean existsCustomersById(Integer id);




}
