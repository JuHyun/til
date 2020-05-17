package item6;

import java.util.regex.Pattern;

public class RomanNumerals {

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // String.matches
    // 장점: 정규표현식으로 문자열 형태를 확인하는 가장 쉬운 방법
    // 단점: 성능이 중요한 상황에서 반복해 사용하기 적합하지 않다. 내부에서 만드는 정규표현식용 Pattern 인스턴스는, 한 번 쓰고 버려져서
    // 곧바로 가비지 컬렉션 대상이 된다.
//    public static boolean isRomanNumeral(String s) {
//        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
//    }

    public static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
