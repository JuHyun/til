package data.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListVersusLinkedList {

    public static void main(String[] params) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // ADD COMPARE
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList add = " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList add = " + (endTime - startTime));
        System.out.println("****************************");

        // GET, SET COMPARE
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList get = " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList get = " + (endTime - startTime));
        System.out.println("****************************");

        // REMOVE COMPARE
        // GET, SET COMPARE
        startTime = System.nanoTime();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList remove = " + (endTime - startTime));
        System.out.println("ArrayList size = " + arrayList.size());

        startTime = System.nanoTime();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList remove = " + (endTime - startTime));
        System.out.println("LinkedList size = " + linkedList.size());
    }
}
