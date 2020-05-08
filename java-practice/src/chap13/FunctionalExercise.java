package chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class FunctionalExercise {

    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);

        return concate(subans, subans2);
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private static List<List<Integer>> concate(List<List<Integer>> list1, List<List<Integer>> list2) {
        List<List<Integer>> r = new ArrayList<>(list1);
        r.addAll(list2);
        return r;
    }

    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int n) {
        return n == 1 ? 1 : n * factorialIterative(n - 1);
    }

    public static int factorialStream(int i) {
        return IntStream.rangeClosed(1, i).reduce(1, (a, b) -> a * b);
    }

    public static int factorialTailRecursive(int i) {
        return factorialHelper(1, i);
    }

    private static int factorialHelper(int acc, int i) {
        return i == 1 ? acc : factorialHelper(acc * i, i - 1);
    }

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }
}
