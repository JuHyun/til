package item14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {

    @Test
    void compareTo() {
        PhoneNumber pn1 = new PhoneNumber((short) 111, (short) 222, (short) 333);
        System.out.println(pn1.compareTo(new PhoneNumber((short) 000, (short) 333, (short) 999)));
    }
}
