package javaeight.stream.introduction;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public CaloricLevel getCaloricLevel() {
        if (this.getCalories() <= 400) return Dish.CaloricLevel.DIET;
        else if (this.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
        else return Dish.CaloricLevel.FAT;
    }

    public enum Type {
        MEAT, OTHER, FISH;
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT;
    }
}
