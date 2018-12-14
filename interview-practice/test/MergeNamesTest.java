import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MergeNamesTest {

    @Test
    public void test() {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        assertThat(MergeNames.uniqueNames(names1, names2), is(new String[]{"Ava", "Emma", "Olivia", "Sophia"}));
    }
}