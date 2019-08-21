package javaeight.behaviour.parameterization;

import java.io.Serializable;

public class Apple implements Serializable {

    private String color;

    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }
}
