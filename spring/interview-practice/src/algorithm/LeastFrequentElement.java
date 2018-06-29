package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentElement {

    public static int leastFrequent(int[] arr, int length) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < length; i++) {
            int key = arr[i];
            if (count.containsKey(key)) {
                count.put(key, count.get(key) + 1);
            } else {
                count.put(key, 1);
            }
        }

        int minValue = length + 1, minKey = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() < minValue) {
                minKey = entry.getKey();
                minValue = entry.getValue();
            }
        }

        return minKey;
    }
}
