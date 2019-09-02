package javaeight.stream.eight.template.method;

public class Database {
    public static Customer getCustomerWithId(int id) {
        return new Customer(id, id + "_name");
    }
}
