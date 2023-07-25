package com.examly.springapp.controller;
import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin()
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Boolean> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        boolean isSuccess = createdCustomer != null;
        return ResponseEntity.ok(isSuccess);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable(value = "id") Long customerId,
            @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        customerService.deleteCustomer(customerId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}