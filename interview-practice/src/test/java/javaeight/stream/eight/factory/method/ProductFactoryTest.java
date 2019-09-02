package javaeight.stream.eight.factory.method;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductFactoryTest {

    @Test
    public void createProduct() {
        Product p = ProductFactory.createProduct("loan");
        assertEquals("Loan", p.getName());
    }

    @Test
    public void createProductWithLambda() {
        Product p = ProductFactory.createProductLambda("loan");
        assertEquals("Loan", p.getName());
    }
}
