package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5DiDemoSpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(Spring5DiDemoSpringDiApplication.class, args);
    }

}

