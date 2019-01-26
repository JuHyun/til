package javabasic.interfacepractice;

public interface IExample1 {

    void print1();

    default void defaultPrint() {
        System.out.println("IExample1 - default method");
    }
}
