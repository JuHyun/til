package algorithm;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class LeastFrequentElementTest {

    @Test
    public void findLeastFrequentElement() {
        int arr[] = {1, 3, 2, 1, 2, 2, 3, 1};

        int leastNumber = LeastFrequentElement.leastFrequent(arr, arr.length);

        assertThat(leastNumber, equalTo(3));
    }

}