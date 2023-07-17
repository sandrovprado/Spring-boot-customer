package com.sandro.customer;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerRowMapperTest {

    private CustomerRowMapper underTest;


    @Test
    void mapRow() throws SQLException {
        // Given
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("sandro");
        when(resultSet.getString("email")).thenReturn("sandro@gmail.com");
        when(resultSet.getInt("age")).thenReturn(24);
        when(resultSet.getString("gender")).thenReturn("FEMALE");


        // When
        Customer actualCustomer = customerRowMapper.mapRow(resultSet, 1);

        // Then
        Customer expectedCustomer = new Customer(1,"sandro","sandro@gmail.com",24, Gender.FEMALE);
        assertThat(actualCustomer).isEqualTo(expectedCustomer);
    }
}