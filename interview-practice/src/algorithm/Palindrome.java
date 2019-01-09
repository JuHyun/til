package algorithm;

import java.util.LinkedList;
import java.util.List;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        if (word == null || "".equals(word)) {
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }

        String upperCaseWord = word.toUpperCase();
        int middle = word.length() / 2;
        for (int index = 0; index < middle + 1; index++) {
            if (upperCaseWord.charAt(index) == upperCaseWord.charAt(word.length() - 1 - index)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String makePalindrome(String string, int l, int h) {
        if (l >= h) {
            return string;
        }
        if (string.charAt(l) == string.charAt(h)) {
            return makePalindrome(string, l + 1, h - 1);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (h == string.length() - 1) {
                stringBuilder.append(string);
                stringBuilder.append(string.charAt(l));
                string = stringBuilder.toString();
            } else {
                stringBuilder.append(string, 0, h + 1);
                stringBuilder.append(string.charAt(l));
                stringBuilder.append(string, h + 1, string.length());
                string = stringBuilder.toString();
            }
            return makePalindrome(string, l + 1, h);
        }
    }

    private static List<Character> converStringToList(String string) {
        List<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            linkedList.add(string.charAt(i));
        }
        return linkedList;
    }
}
