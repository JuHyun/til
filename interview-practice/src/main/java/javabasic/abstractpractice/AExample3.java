package javabasic.abstractpractice;

public abstract class AExample3 extends AExample1 {

    public abstract void print3();

    protected void concretePrint3() {
        System.out.println("AExample3 - concretePrint3");
    }
}
