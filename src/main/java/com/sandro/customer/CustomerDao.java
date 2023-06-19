package com.sandro.customer;

import java.util.List;
import java.util.Optional;

//Data Access Object/Communicates with data store(db/file/List)
public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id); //use Optional class b/c id might not be in list
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Integer Id);
    void deleteCustomerById(Integer customerId);

}
