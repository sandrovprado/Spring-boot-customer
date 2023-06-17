package com.sandro.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//API layer (Intercepts client http requests)
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)

    @GetMapping("/api/v1/customers") //same as @RequestMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/api/v1/customers/{customerId}") //another endpoint getting individual customers by creating {variable}
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) { //filter customer by ID using @PathVar annotation
        return customerService.getCustomer(customerId);
    }
}
