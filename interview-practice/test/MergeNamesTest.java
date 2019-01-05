import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeNamesTest {

    @Test
    public void test() {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        String[] expected = new String[]{"Ava", "Emma", "Olivia", "Sophia"};
        assertArrayEquals(expected, MergeNames.uniqueNames(names1, names2));
    }
}
