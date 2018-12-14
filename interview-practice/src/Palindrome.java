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
}