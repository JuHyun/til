package algorithm.codility;

public class MaxinumNumber {

    // -8000 ~ 8000
    // - : 45
    // 0: 48
    // 1: 49
    // 5: 53
    // ...
    // 9: 59
    public static int solution(int N) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean negative = N < 0;

        String numberString = Integer.toString(Math.abs(N));
        for (int i = 0; i < numberString.length(); i++) {
            if (!negative) {
                // case 1. 첫번째 숫자가 5보다 작을 경우.
                if (i == 0 && numberString.charAt(i) < '5') {
                    stringBuilder.append("5").append(numberString);
                    break;
                }

                // case 1. + >= 800
                if (N >= 800) {
                    stringBuilder.append(5).append(numberString);
                    break;
                }

                if (numberString.charAt(i) > '5') {
                    stringBuilder.append(numberString.charAt(i));
                } else {
                    stringBuilder.append(5)
                            .append(numberString.substring(i));
                    break;
                }
            } else {
                if (N <= -800) {
                    stringBuilder.append(5).append(numberString);
                    break;
                }

                if (numberString.charAt(i) < '5') {
                    stringBuilder.append(numberString.charAt(i));
                } else {
                    stringBuilder.append(5)
                            .append(numberString.substring(i));
                    break;
                }
            }
        }

        return Integer.parseInt(stringBuilder.toString()) * (negative ? -1 : 1);
    }
}
