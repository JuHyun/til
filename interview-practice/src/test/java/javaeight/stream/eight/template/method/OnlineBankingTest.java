package javaeight.stream.eight.template.method;

import org.junit.Test;

public class OnlineBankingTest {

    @Test
    public void makeCustomerHappy() {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello, " + c.getName()));
    }
}
