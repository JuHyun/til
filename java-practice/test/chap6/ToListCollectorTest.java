package chap6;

import chap4.Dish;
import org.junit.Test;

import java.util.List;

public class ToListCollectorTest {

    @Test
    public void test() {
        List<Dish> dishes = Dish.menu.stream().collect(new ToListCollector<Dish>());
    }
}
