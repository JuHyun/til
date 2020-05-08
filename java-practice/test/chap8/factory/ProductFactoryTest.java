package chap8.factory;

import static junit.framework.TestCase.assertNotNull;

import org.junit.Test;

public class ProductFactoryTest {

    @Test
    public void test() {
        Product product = ProductFactory.createProduct("loan");

        assertNotNull(product);
    }
}
