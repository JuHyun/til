package chap8;

import org.junit.Test;

public class OnlineBankingTest {

    @Test
    public void test() {
        new OnlineBankingImpl().processCustomer(1);
    }
}
