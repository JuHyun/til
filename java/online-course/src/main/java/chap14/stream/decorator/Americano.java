package chap14.stream.decorator;

public class Americano extends Decorator {

    public Americano(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("물을 더해주세요.");
    }
}
