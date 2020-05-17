package chap5.item26;

import java.util.Arrays;

public class UnsafeArray {
    private static Object[] elementData = new Object[]{};

    private static int size = 0;

    public static <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 생성한 배열과 배개변수로 받은 배열의 타입이 모두 T[]로 같으므로 올바른 형변환이다.
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elementData, size, a.getClass());
            return result;
        }

        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public static void main(String[] args) {
        toArray(new String[]{"1"});
    }
}
