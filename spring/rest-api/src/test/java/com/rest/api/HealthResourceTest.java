package com.rest.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Response;

/**
 * Health Resource Test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthResourceTest extends ApiTest {

    @Test
    public void health() {
        Response response = target("health").request().get();

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
        assertThat(response.readEntity(String.class))
                .contains("\"status\":\"Strong\"");
    }
}
