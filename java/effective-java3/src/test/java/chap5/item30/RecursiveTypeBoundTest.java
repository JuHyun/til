package chap5.item30;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

class RecursiveTypeBoundTest {

    @Test
    void max() {
        Collection<Integer> collection = List.of(1, 2, 3);
        Optional<Integer> max = RecursiveTypeBound.max(collection);

        assertEquals(3, max.orElseGet(() -> 0));
    }
}
