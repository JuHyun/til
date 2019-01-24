package javabasic.interfacepractice;

public class IExample3 implements IExample1, IExample2 {

    @Override
    public void print1() {
        System.out.println("IExample3 - print1");
    }

    @Override
    public void print2() {
        System.out.println("IExample3 - print2");
    }
}
