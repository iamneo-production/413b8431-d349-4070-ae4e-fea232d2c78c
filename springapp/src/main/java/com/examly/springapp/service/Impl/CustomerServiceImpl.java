package com.examly.springapp.service.Impl;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepository;
import com.examly.springapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new ResourceNotFoundException("Customer not found with ID: " + customerId);
        }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = getCustomerById(customerId);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setAddress(customerDetails.getAddress());
        customer.setCommunicationHistory(customerDetails.getCommunicationHistory());
        customer.setPurchaseHistory(customerDetails.getPurchaseHistory());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws ResourceNotFoundException {
        Customer customer = getCustomerById(customerId);
        customerRepository.delete(customer);
    }
}