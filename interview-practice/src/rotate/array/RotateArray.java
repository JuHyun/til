package rotate.array;

public class RotateArray {
    public static int[] rotate(int[] array, int rotateCount) {
        if (rotateCount <= 0 || rotateCount == array.length || array == null) {
            return array;
        }

        if (rotateCount > array.length) {
            rotateCount = rotateCount % array.length;
        }
//        // case1.
//        int[] result = new int[array.length];
//        System.arraycopy(array, array.length - rotateCount, result, 0, rotateCount);
//        System.arraycopy(array, 0, result, rotateCount, array.length - rotateCount);
//
//        return result;

        // case2. reverse sort 2 twice, and then reverse.
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        reverse(result, 0, result.length - rotateCount - 1);
        reverse(result, result.length - rotateCount, result.length - 1);
        reverse(result, 0, result.length - 1);

        return result;
    }

    public static void reverse(int[] array, int left, int right) {
        if (right - left == 0) return;

        while (left <= right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
