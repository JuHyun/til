package com.rest.backdoor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Response;

/**
 * Created by seoungjuhyun on 4/29/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackdoorResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String FIRST_NAME = "Estel";

    private static final String LAST_NAME = "Castle";

    @Test
    public void create() {
        String url = "/_backdoor/create/" + FIRST_NAME + "/" + LAST_NAME;
        Response response = restTemplate.getForObject(url, Response.class);

        assertThat(response.getStatusInfo()).isEqualTo(HttpStatus.OK);
    }
}
