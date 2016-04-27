package com.rest.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.rest.domain.Health;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Health Resource Test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HealthResourceTest {

    private static final String ACCESS_URL = "http://localhost:8080/api/health";

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void health() {
        ResponseEntity<Health> responseEntity =
                restTemplate.getForEntity(ACCESS_URL, Health.class);

        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntity.getBody().getStatus()).isEqualTo("Strong");
    }
}
