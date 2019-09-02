package javaeight.stream.eight.observer;

public interface Subject {

    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
