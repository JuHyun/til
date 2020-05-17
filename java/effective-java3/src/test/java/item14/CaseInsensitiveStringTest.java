package item14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CaseInsensitiveStringTest {

    @Test
    void compareTo() {
        List<CaseInsensitiveString> list =
                Arrays.asList(new CaseInsensitiveString("AAA"), new CaseInsensitiveString("ccc"),
                        new CaseInsensitiveString("aaa"));
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }
}
