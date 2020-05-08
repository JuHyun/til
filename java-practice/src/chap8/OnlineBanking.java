package chap8;

public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer c);

    public static class Customer {
        private final int id;

        public Customer(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static class Database {
        public static Customer getCustomerWithId(int id) {
            return new Customer(id);
        }
    }
}
