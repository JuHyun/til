package guru.springframework;

import guru.springframework.controllers.MyContoller;
import guru.springframework.examplebeans.FakeDataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5DiDemoSpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(Spring5DiDemoSpringDiApplication.class, args);

        MyContoller myContoller = (MyContoller) applicationContext.getBean("myContoller");

        FakeDataSource fakeDataSource = (FakeDataSource) applicationContext.getBean("fakeDataSource");
        System.out.println(String.format("%s, %s, %s", fakeDataSource.getUsername(),
                fakeDataSource.getPassword(), fakeDataSource.getUrl()));
    }
}

