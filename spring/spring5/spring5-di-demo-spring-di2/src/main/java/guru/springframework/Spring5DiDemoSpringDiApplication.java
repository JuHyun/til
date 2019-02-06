package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.MyContoller;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.config", "guru.services", "guru.springframework"})
public class Spring5DiDemoSpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(Spring5DiDemoSpringDiApplication.class, args);

        MyContoller myContoller = (MyContoller) applicationContext.getBean("myContoller");

        System.out.println(myContoller.hello());
        System.out.println(applicationContext.getBean(ConstructorInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(SetterInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(PropertyInjectedController.class).sayHello());
    }
}

