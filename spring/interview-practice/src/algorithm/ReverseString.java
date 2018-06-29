package algorithm;

import java.util.*;

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

    // TODO: 깔끔하게 바꿔보면 좋을 듯.
    public static String appendLastPalindrome(String original) {
        if (isPalindrome(original)) {
            return original;
        }

        StringBuilder resultBuilder = new StringBuilder(original);
        for (int i = 0; i < original.length(); i++) {
            int maxLength = resultBuilder.length();
            resultBuilder.insert(maxLength - i, original.charAt(i));

            if (isPalindrome(resultBuilder.toString())) {
                return resultBuilder.toString();
            }
        }

        return resultBuilder.toString();
    }

    private static boolean isPalindrome(String original) {
        if (original.length() <= 1) {
            return true;
        }

        return original.equals(reverse(original));
    }
}
