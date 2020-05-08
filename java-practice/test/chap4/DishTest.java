package chap4;

import static java.util.stream.Collectors.toList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DishTest {

    @Test
    public void wordLength() {
        List<Integer> dishNameLength = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        System.out.println(dishNameLength);
    }

    @Test
    public void 스트림_평면화() {
        List<String[]> distinctName = Dish.menu.stream()
                .map(dish -> dish.getName().split(""))
                .distinct()
                .collect(toList());

        List<String> collect = distinctName.stream()
                .flatMap(strings -> Arrays.stream(strings))
                .collect(toList());
        collect.stream().forEach(System.out::println);
    }
}
