package chap14.stream.decorator;

public class EttiopiaCoffee extends Coffee {
    @Override
    public void brewing() {
        System.out.println("에티오피아 에스프레소입니다.");
    }
}
