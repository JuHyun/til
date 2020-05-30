package chap14.stream.decorator;

public class Mocha extends Decorator {

    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("모카 크림을 더해주세요.");
    }
}
