package item2.hierarchicalbuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PizzaTest {

    @Test
    public void build() {
        NyPizza nyPizza = (NyPizza) new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.ONION)
                .build();
        System.out.println(nyPizza.toppings.iterator().next());

        Calzone calzone = (Calzone) new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.PEPPER)
                .sauceInside()
                .build();

        assertTrue(calzone.isSauceInside());
    }
}
