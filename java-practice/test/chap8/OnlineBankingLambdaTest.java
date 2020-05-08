package chap8;

import org.junit.Test;

public class OnlineBankingLambdaTest {

    @Test
    public void test() {
        new OnlineBankingLambda().processCustomer(1, (OnlineBanking.Customer c) -> System.out.println("Hello"));
    }
}
