package chap5.item30;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class RecursiveTypeBound {

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty.");
        }

        Optional<E> result = Optional.empty();
        for (E e : collection) {
            if (result.isEmpty() || e.compareTo(result.get()) > 0) {
                result = Optional.of(Objects.requireNonNull(e));
            }
        }
        return result;
    }
}
