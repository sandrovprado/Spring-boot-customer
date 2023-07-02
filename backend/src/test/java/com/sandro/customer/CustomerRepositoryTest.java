package com.sandro.customer;

import com.sandro.AbstractTestcontainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest //only necessary beans for jpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //disable embedded db
class CustomerRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private CustomerRepository underTest;

//    public CustomerRepositoryTest(CustomerRepository underTest) { **Same as autowired**
//        this.underTest = underTest;
//    }

    @BeforeEach
    void setUp() {
        underTest.deleteAll(); //delete db content when test is finished
    }

    @Test
    void existsCustomersByEmail() {
        // Given
        String email = FAKER.internet().safeEmailAddress() + " " + UUID.randomUUID();
        Customer customer = new Customer(
                FAKER.name().fullName(),
                email,
                20
        );
        underTest.save(customer);

        // When
        var actualCustomer = underTest.existsCustomersByEmail(email);

        // Then
        assertThat(actualCustomer).isTrue();
    }

    @Test
    void existsCustomersByEmailFailsWhenEmailNotPresent() {
        // Given
        String email = FAKER.internet().safeEmailAddress() + " " + UUID.randomUUID();
        //not saving customer this time


        // When
        var actualCustomer = underTest.existsCustomersByEmail(email);

        // Then
        assertThat(actualCustomer).isFalse();
    }

    @Test
    void existsCustomersById() {
        // Given
        String email = FAKER.internet().safeEmailAddress() + " " + UUID.randomUUID();
        Customer customer = new Customer(
                FAKER.name().fullName(),
                email,
                20
        );
        underTest.save(customer);

        int id = underTest.findAll()
                .stream()
                .filter(c -> c.getEmail().equals(email))
                .map(c -> c.getId())
                .findFirst()
                .orElseThrow();

        // When
        var actualCustomer = underTest.existsCustomersById(id);

        // Then
        assertThat(actualCustomer).isTrue();
    }

    @Test
    void existsCustomersByIdFailsWhenIdNotPresent() {
        // Given
        int id = -1;

        // When
        var actualCustomer = underTest.existsCustomersById(id);

        // Then
        assertThat(actualCustomer).isFalse();
    }
}