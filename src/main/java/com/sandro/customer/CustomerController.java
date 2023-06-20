package com.sandro.customer;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API layer (Intercepts client http requests)
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)

    @GetMapping() //Root path in @RequestMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}") //another endpoint getting individual customers by creating {variable}
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) { //filter customer by ID using @PathVar annotation
        return customerService.getCustomer(customerId);
    }

    @PostMapping()//Root path in @RequestMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){ //@RequestBody includes json object of new customer
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId")Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Integer customerId,
            @RequestBody CustomerUpdateRequest customerUpdateRequest){
        customerService.updateCustomer(customerId,customerUpdateRequest);

    }



}
