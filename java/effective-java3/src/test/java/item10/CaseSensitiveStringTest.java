package item10;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CaseSensitiveStringTest {

    @Test
    void testEquals() {
        CaseSensitiveString polish = new CaseSensitiveString("Polish");
        String s = "polish";
        assertFalse(polish.equals(s));
    }

    @Test
    void testEquals2() {
        CaseSensitiveString polish = new CaseSensitiveString("Polish");
        String s = "polish";

        List<CaseSensitiveString> list = new ArrayList<>();
        list.add(polish);

        assertFalse(list.contains(s));
    }
}
