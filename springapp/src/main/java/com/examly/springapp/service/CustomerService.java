package com.examly.springapp.service;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId) throws ResourceNotFoundException;

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customerDetails) throws ResourceNotFoundException;

    void deleteCustomer(Long customerId) throws ResourceNotFoundException;
}