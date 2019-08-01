package algorithm;

public class OddOccurrencesInArray {

//    public static int solution(int[] A) {
//        // write your code in Java SE 8
//        Arrays.sort(A);
//
//        int result = 0;
//        boolean flag = true;
//        for (int i = 0; i < A.length; i++) {
//            int multiply = flag ? 1 : -1;
//            result += (A[i] * multiply);
//            flag = !flag;
//        }
//
//        return result;
//    }

    // xor 비트 연산. 같으면 0, 다르면 1... => 이해안감.
    // 참고: https://duzi077.tistory.com/278
    public static int solution(int[] A) {
        int result = 0;
        for (int v : A) {
            result = result ^ v;
        }
        return result;
    }
}
