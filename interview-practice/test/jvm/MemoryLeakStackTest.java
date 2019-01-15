package jvm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemoryLeakStackTest {

    @Test
    public void memoryLeak() {
        MemoryLeakStack<Integer> memoryLeakStack = new MemoryLeakStack<Integer>();
        memoryLeakStack.push(Integer.valueOf(100));
        Integer pop = memoryLeakStack.pop();

        System.gc();

        memoryLeakStack.push(Integer.valueOf(200));
    }
}
