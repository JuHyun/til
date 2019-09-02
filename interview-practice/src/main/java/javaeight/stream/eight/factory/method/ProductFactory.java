package javaeight.stream.eight.factory.method;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> supplier = map.get(name);
        if (supplier != null) {
            return supplier.get();
        }
        throw new RuntimeException("No such product " + name);
    }
}
