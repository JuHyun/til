package item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

class WordList {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        Collections.addAll(set, args);
        System.out.println(set);
    }
}
