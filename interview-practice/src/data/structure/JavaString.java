package data.structure;

public class JavaString {

    private static final int MUTLIPLY_TEN = 10;
    private static final char NUMBER_BOTTOM = '0';
    private static final char NUMBER_TOP = '9';

    public static int atoi(String value) {
        byte[] bytes = value.getBytes();
        int result = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte thisOne = bytes[i];
            if (thisOne < NUMBER_BOTTOM || thisOne > NUMBER_TOP) {
                throw new IllegalArgumentException("숫자형 문자만 허용됩니다.");
            }
            result = (result * MUTLIPLY_TEN) + (thisOne - NUMBER_BOTTOM);
        }
        return result;
    }
}
