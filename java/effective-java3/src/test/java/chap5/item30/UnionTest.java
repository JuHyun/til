package chap5.item30;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

class UnionTest {

    @Test
    void union() {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Rarry", "Moe", "Curly");
        Set<String> aflCio = Union.union(guys, stooges);
        System.out.println(aflCio);
    }
}
