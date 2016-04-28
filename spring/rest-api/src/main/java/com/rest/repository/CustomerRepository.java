package com.rest.repository;

import com.rest.domain.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository.
 */
@Repository
public interface CustomerRepository
        extends PagingAndSortingRepository<Customer, Long> {
}
