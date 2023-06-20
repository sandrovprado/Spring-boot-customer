package com.sandro.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list") //name for @Qualifier
public class CustomerListDataAccessService implements CustomerDao {

    // Fake database
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer sandro = new Customer(1, "Sandro", "sandro@gmail.com", 25);
        Customer alex = new Customer(2, "Alex", "Alex@gmail.com", 21);
        customers.add(sandro);
        customers.add(alex);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        //service class is in charge of throwing exception

    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(customer -> customer.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Integer Id) {
        return customers.stream()
                .anyMatch(customer -> customer.getEmail().equals(Id));
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .ifPresent(customers::remove);

    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }
}
