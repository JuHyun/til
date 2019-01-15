package jvm;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakStack<E> {
    private String objName;
    private final List<E> stackValue;
    private int stackPointer;

    public MemoryLeakStack() {
        stackValue = new ArrayList<>();
        stackPointer = 0;
    }

    public void push(E element) {
        stackValue.add(element);
        stackPointer++;
    }

    public E pop() {
        stackPointer--;
        return stackValue.get(stackPointer);
    }

    /* Overriding finalize method to check which object is garbage collected */
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.objName + " successfully garbage collected");
    }
}
