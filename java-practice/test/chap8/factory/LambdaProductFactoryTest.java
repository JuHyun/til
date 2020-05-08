package chap8.factory;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LambdaProductFactoryTest {

    @Test
    public void test() {
        Product product = LambdaProductFactory.createProduct("loan");
        assertNotNull(product);
    }
}
