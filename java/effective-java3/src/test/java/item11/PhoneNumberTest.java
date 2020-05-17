package item11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PhoneNumberTest {

    @Test
    void testHashCode() {
        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber((short) 707, (short) 867, (short) 5309), "V");

        assertEquals("V", map.get(new PhoneNumber((short) 707, (short) 867, (short) 5309)));
    }

    @Test
    void testToString() {
        PhoneNumber phoneNumber = new PhoneNumber((short) 707, (short) 867, (short) 5309);
        assertEquals(String.format("%03d-%03d-%04d", 707, 867, 5309), phoneNumber.toString());
    }
}
