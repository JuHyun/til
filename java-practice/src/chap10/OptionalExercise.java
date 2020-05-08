package chap10;

import java.util.Optional;

public class OptionalExercise {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return person.getCar().get().getInsurance().get();
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(person1 -> car.map(car1 -> findCheapestInsurance(person1, car1)));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAage) {
        return person.filter(p -> p.getAge() >= minAage)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
