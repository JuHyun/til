package javaeight.behaviour.parameterization;

public class Spinichi {

    private Integer weight;

    private String origin;

    public Spinichi(Integer weight, String origin) {
        this.weight = weight;
        this.origin = origin;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spinichi)) return false;

        Spinichi spinichi = (Spinichi) o;

        if (!weight.equals(spinichi.weight)) return false;
        return origin.equals(spinichi.origin);
    }

    @Override
    public int hashCode() {
        int result = weight.hashCode();
        result = 31 * result + origin.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Spinichi{" +
                "weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
