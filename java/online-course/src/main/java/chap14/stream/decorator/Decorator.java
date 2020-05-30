package chap14.stream.decorator;

public abstract class Decorator extends Coffee {

    private Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void brewing() {
        coffee.brewing();
    }
}
