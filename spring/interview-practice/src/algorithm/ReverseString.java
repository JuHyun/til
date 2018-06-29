package algorithm;

public class ReverseString {
    public static String reverse(String original) {

        char[] temp = original.toCharArray();
//        int left = 0;
        int right = original.length() - 1;
        for (int left = 0; left < right; left++, right--) {
            temp[left] = original.charAt(right);
            temp[right] = original.charAt(left);
        }

        return String.valueOf(temp);
    }
}
