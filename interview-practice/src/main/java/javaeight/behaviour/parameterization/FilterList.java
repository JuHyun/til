package javaeight.behaviour.parameterization;

import java.util.ArrayList;
import java.util.List;

public class FilterList {

    public static <T> List<T> filter(List<T> list, CustomPredicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }
}
