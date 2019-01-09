package algorithm;

public class ReverseString {
    public static String reverse(String string) {
        int length = string.length();

        if (string == null || length == 0) {
            throw new IllegalStateException("빈 문자는 허용되지 않습니다.");
        }

        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < length / 2; i++) {
            int pointIndex = length - 1 - i;
            char temp = string.charAt(pointIndex);
            stringBuilder.setCharAt(pointIndex, string.charAt(i));
            stringBuilder.setCharAt(i, temp);
        }

        return stringBuilder.toString();
    }
}
