package com.rest.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * HelloWorld 리소스 테스트.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloWorldResourceTest {

    private static final String HOST_NAME = "http://localhost:8080/api";

    private static final String HELLO_WORLD = "Hello World";

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void hello() {
        String accessUrl = HOST_NAME + "/hello/world";

        String result = restTemplate.getForObject(accessUrl, String.class);

        assertThat(result).isEqualTo(HELLO_WORLD);
    }
}
