package serialization;

import java.io.Serializable;

public class Pair implements Serializable {

    private final int number;

    private final String name;

    public Pair(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Pair create(int number, String name) {
        Pair pair = new Pair(number, name);
        return pair;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
