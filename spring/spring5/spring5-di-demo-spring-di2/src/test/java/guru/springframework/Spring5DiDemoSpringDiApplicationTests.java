package guru.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"guru.services", "guru.springframework"})
public class Spring5DiDemoSpringDiApplicationTests {

    @Test
    public void contextLoads() {
    }
}

