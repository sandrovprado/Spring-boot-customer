package com.sandro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {

    // Using list as a db
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer sandro = new Customer(1, "Sandro", "sandro@gmail.com", 25);
        Customer alex = new Customer(2, "Alex", "Alex@gmail.com", 21);
        customers.add(sandro);
        customers.add(alex);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

//    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)

    @GetMapping("/api/v1/customers") //same as @RequestMapping
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/api/v1/customers/{customerId}") //another endpoint getting individual customers by creating {variable}
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) { //filter customer by ID using @PathVar annotation

        return customers.stream()
                .filter(customer -> customer.id.equals(customerId))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("customer with id [%s] not found".formatted(customerId)));
    }


    static class Customer {
        private Integer id;
        private String name;
        private String email;
        private Integer age;

        public Customer() {
        }

        public Customer(Integer id, String name, String email, Integer age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, email, age);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
