package algorithm;

public class BinaryGapPositive {

    //    public static int solution(int n) {
//        String binaryString = Integer.toBinaryString(n);
//        System.out.println(binaryString);
//
//        int maxGap = 0;
//        for (int i = 0; i < binaryString.length() - 1; i++) {
//            char point = binaryString.charAt(i);
//            if (point != '1') {
//                continue;
//            }
//            for (int j = i + 1; j < binaryString.length(); j++) {
//                char compared = binaryString.charAt(j);
//                if (compared == '1') {
//                    System.out.println("maxGap = " + maxGap + ", i = " + i + ", j = " + j);
//                    maxGap = j - i - 1 > maxGap ? j - i - 1: maxGap;
//                    i = j;
//                }
//            }
//        }
//
//        return maxGap;
//    }
    public static int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] chars = binaryString.toCharArray();

        int gap = 0, result = 0;

        for (char c : chars) {
            if (c == '0') {
                gap++;
            } else {
                if (gap > result) {
                    result = gap;
                }
                gap = 0;
            }
        }

        return result;
    }
}
