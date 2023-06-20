package com.sandro.customer;

import com.sandro.exception.DuplicateResourceException;
import com.sandro.exception.RequestValidationException;
import com.sandro.exception.ResourceNotFoundException;
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

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers(); //from customerDao interface
    }

    public Customer getCustomer(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("customer with id [%s] not found".formatted(id)));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        String email = customerRegistrationRequest.email();
        if (customerDao.existsPersonWithEmail(email)) {
            throw new DuplicateResourceException("Email already taken!");
        } else {
            Customer customer = new Customer(
                    customerRegistrationRequest.name(),
                    customerRegistrationRequest.email(),
                    customerRegistrationRequest.age()
            );
            customerDao.insertCustomer(customer);
        }
    }

    public void deleteCustomerById(Integer customerId) {
        if (!customerDao.existsPersonWithId(customerId)) {
            throw new ResourceNotFoundException("customer with id [%s] not found".formatted(customerId));
        }
        customerDao.deleteCustomerById(customerId);

    }

   public void updateCustomer(Integer customerId,CustomerUpdateRequest customerUpdateRequest){
        Customer customer = getCustomer(customerId);

        boolean changes = false;

        //if customer is not null and updated value != original value

        if(customerUpdateRequest.name() !=null && !customerUpdateRequest.name().equals(customer.getName())){
            customer.setName(customerUpdateRequest.name());
            changes = true;
        }
       if(customerUpdateRequest.age() !=null && !customerUpdateRequest.age().equals(customer.getAge())){
           customer.setAge(customerUpdateRequest.age());
           changes = true;
       }
       if(customerUpdateRequest.email() !=null && !customerUpdateRequest.email().equals(customer.getEmail())){
           if(customerDao.existsPersonWithEmail(customerUpdateRequest.email())){
               throw new DuplicateResourceException("Email already taken!");
           }
           customer.setEmail(customerUpdateRequest.email());
           changes = true;
       }

       if(!changes){
           throw new RequestValidationException("No data changes found");
       }

       customerDao.updateCustomer(customer);


   }


}
