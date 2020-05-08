package chap10;

import java.util.Optional;

public class Person {

    private int age;

    private Optional<Car> car;

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}
