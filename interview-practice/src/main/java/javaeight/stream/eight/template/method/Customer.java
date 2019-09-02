package javaeight.stream.eight.template.method;

public class Customer {

    private int id;
    private String name;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
