package algorithm;

import java.util.ArrayList;
import java.util.List;

public class IntegerUpdate {
    public static List<Object> update(List<Integer> list, GenericOperator<Integer, Object> operator) {
        if (list == null) {
            throw new IllegalStateException("list가 비었네요...");
        }

        List<Object> result = new ArrayList<>(list.size());
        for (Integer integer: list) {
            result.add(operator.performOperator(integer));
        }
        return result;
    }
}
