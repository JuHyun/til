package chap14.stream.decorator;

import org.junit.jupiter.api.Test;

class DecoratorTest {

    @Test
    void brewing() {
        Latte latte = new Latte(new KenyaCoffee());
        latte.brewing();

        Mocha mocha = new Mocha(new Latte(new KenyaCoffee()));
        mocha.brewing();

        Americano americano = new Americano(new EttiopiaCoffee());
        americano.brewing();
    }
}
