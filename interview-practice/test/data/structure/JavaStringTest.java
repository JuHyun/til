package data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.NumberFormat;
import java.util.Locale;

class JavaStringTest {

    @Test
    public void allocation() {
        final char[] value;

        value = new char[]{'a', 'b', 'c', 'd', 'e'};
        System.out.println(String.format("hashCode: %d, %s, %s", value.hashCode(), value.toString(), print(value)));

        char[] anotherValue;
        anotherValue = new char[]{49, 50, 51, 52, 53, 54, 55};
        System.out.println(String.format("hashCode: %d, %s, %s", anotherValue.hashCode(), anotherValue.toString(), print(anotherValue)));

        anotherValue = value;
        System.out.println(String.format("hashCode: %d, %s, %s", value.hashCode(), value.toString(), print(value)));
        System.out.println(String.format("hashCode: %d, %s, %s", anotherValue.hashCode(), anotherValue.toString(), print(anotherValue)));

        char[] otherValue = new char[]{'가', '나', '다', '라', '마', '바', '사', '아', '자', '차', '카', '타', '파', '하'};
        System.out.println(String.format("hashCode: %d, %s, %s", otherValue.hashCode(), otherValue.toString(), print(otherValue)));

        anotherValue = otherValue;
        System.out.println(String.format("hashCode: %d, %s, %s", value.hashCode(), value.toString(), print(value)));
        System.out.println(String.format("hashCode: %d, %s, %s", anotherValue.hashCode(), anotherValue.toString(), print(anotherValue)));
        System.out.println(String.format("hashCode: %d, %s, %s", otherValue.hashCode(), otherValue.toString(), print(otherValue)));
    }

    private String print(final char[] value) {
        return String.valueOf(value);
    }

    @Test
    public void atoi() {
        assertEquals(123, JavaString.atoi("123"));
    }

    @Test
    public void currencyWithComma() {
        String currency = JavaString.currencyWithComma("1335780");
        assertEquals("1,335,780", currency);
    }
}
