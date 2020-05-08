package chap8;

import java.util.function.Consumer;

public class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<OnlineBanking.Customer> makeCustomerHappy) {
        OnlineBanking.Customer customer = OnlineBanking.Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }
}
