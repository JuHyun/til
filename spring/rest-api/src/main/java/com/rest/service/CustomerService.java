package com.rest.service;

import com.rest.domain.Customer;
import com.rest.repository.CustomerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Customer Service.
 */
@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer save(String firstname, String lastname) {
        Customer customer = new Customer(firstname, lastname);
        return customerRepository.save(customer);
    }

    public Page<Customer> findAll(int page, int size, List<String> sort, String direction) {
        PageRequest pageRequest = new PageRequest(page, size,
                Sort.Direction.fromString(direction),
                sort.toArray(new String[0])
        );
        return customerRepository.findAll(
                pageRequest);
    }

    public Customer update(Long id, Customer customer) {
        Customer originalCustomer = customerRepository.findOne(id);
        originalCustomer.setFirstname(customer.getFirstname());
        originalCustomer.setLastname(customer.getLastname());
        return customerRepository.save(originalCustomer);
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
