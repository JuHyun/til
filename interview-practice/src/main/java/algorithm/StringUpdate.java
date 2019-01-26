package algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringUpdate {

    public static List<Object> update(List<String> list, GenericOperator<String, Object> operator) {
        if (list == null) {
            throw new IllegalStateException("list가 비었네요...");
        }

        List<Object> result = new ArrayList<>(list.size());
        for (String string: list) {
            result.add(operator.performOperator(string));
        }
        return result;
    }
}
