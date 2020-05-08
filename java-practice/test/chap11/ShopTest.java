package chap11;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopTest {

    private Shop shop = new Shop("BestShop");

    @Test
    public void getPrice() {
        long start = System.nanoTime();
        double price = shop.getPrice("my favorite product");
        System.out.println("duration = " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        System.out.println("price = " + price);
    }

    @Test
    public void getPriceAsync() throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAysnc("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs.");
        Double price = futurePrice.get();
        System.out.printf("Price is %.2f%n", price);
        System.out.println("Price returned after " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
    }

    @Test
    public void getPriceInfo() {
        long start = System.nanoTime();
        String priceInfo = shop.getPriceInfo("my favorite product");
        System.out.println("duration = " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        System.out.println("price = " + priceInfo);
    }
}
