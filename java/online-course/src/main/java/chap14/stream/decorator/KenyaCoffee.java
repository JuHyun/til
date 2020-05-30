package chap14.stream.decorator;

public class KenyaCoffee extends Coffee {

    @Override
    public void brewing() {
        System.out.println("케냐 에스프레소");
    }
}
