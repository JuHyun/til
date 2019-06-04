package com.rest.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.rest.domain.Customer;
import com.rest.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

/**
 * Customer Resource Test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerResourceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private Long customerId;

    @Before
    public void setUp() {
        Customer customer = new Customer("Estel", "Seong");
        customerRepository.save(customer);
        customerId = customer.getId();
    }

    @Test
    public void save() {
        // When
        final Customer newCustomer = new Customer("Estel", "Seong");

        ResponseEntity<Customer> responseEntity =
                restTemplate.postForEntity("/customers", newCustomer,
                        Customer.class);

        // Then

        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);

        HttpHeaders headers = responseEntity.getHeaders();
        URI location = headers.getLocation();

        ResponseEntity<Customer> response =
                restTemplate.getForEntity(location, Customer.class);

        Customer savedCustomer = response.getBody();

        assertThat(savedCustomer.getFirstname())
                .isEqualTo(newCustomer.getFirstname());
        assertThat(savedCustomer.getLastname())
                .isEqualTo(newCustomer.getLastname());
    }

    @Test
    public void returnsOne() {
        // When

        ResponseEntity<Customer> responseEntity =
                restTemplate.getForEntity("/customers/" + customerId,
                        Customer.class);

        // Then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Customer cutomer = responseEntity.getBody();

        assertThat(cutomer.getFirstname()).contains("Estel");
    }

//    @Test
//    public void returnsAllPages() {
//        // When
//
//        ResponseEntity<Page<Customer>> responseEntity =
//                getCustomers("/customers");
//        Page<Customer> customerPage = responseEntity.getBody();
//
//        // Then
//
//        assertThat(customerPage.getTotalPages()).isEqualTo(0);
//        assertThat(customerPage.getTotalElements()).isEqualTo(1);
//        assertThat(customerPage.getSize()).isEqualTo(20);
//        assertThat(customerPage.getNumber()).isEqualTo(0);
//        assertThat(customerPage.getContent()).isEqualTo(1);
//    }

    @Test
    public void update() {
        // When

        Customer customer = new Customer("NEW-FIRSTNAME", "NEW-LASTNAME");
        HttpEntity httpEntity = new HttpEntity(customer);
        ResponseEntity<Customer> responseEntity =
                restTemplate.exchange("/customers/" + customerId,
                        HttpMethod.PUT,  httpEntity, Customer.class);

        // Then

        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        Customer foundCustomer = responseEntity.getBody();

        assertThat(foundCustomer.getId()).isEqualTo(customerId);
        assertThat(foundCustomer.getFirstname()).isEqualTo("NEW-FIRSTNAME");
        assertThat(foundCustomer.getLastname()).isEqualTo("NEW-LASTNAME");
    }

    @Test
    public void delete() {
        // When

        restTemplate.delete("/customers/" + customerId);

        // Then

        ResponseEntity<Customer> responseEntity =
                restTemplate.getForEntity("/customers/" + customerId,
                        Customer.class);

        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<Page<Customer>> getCustomers(String uri) {
        return restTemplate.exchange(
                uri, HttpMethod.GET, null, getParameterizedPageTypeReference()
        );
    }

    private ParameterizedTypeReference<Page<Customer>>
        getParameterizedPageTypeReference() {
            return new ParameterizedTypeReference<Page<Customer>>() {
        };
    }
}
