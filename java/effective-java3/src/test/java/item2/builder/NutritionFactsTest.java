package item2.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NutritionFactsTest {

    @Test
    public void builder() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(100, 3)
                .calories(120)
                .fat(5)
                .sodium(0)
                .carbohydrate(27)
                .build();

        assertEquals(120, nutritionFacts.getCalories());
    }
}
