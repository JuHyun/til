package chap10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

public class OptionalUtilityTest {

    @Test
    public void test() {
        Optional<Integer> integer = OptionalUtility.stringToInt("1234");
        System.out.println(integer);

        System.out.println(OptionalUtility.stringToInt("aaa134"));
    }

    @Test
    public void testReadDuration() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, OptionalUtility.readDuration(props, "a"));
        assertEquals(0, OptionalUtility.readDuration(props, "b"));
        assertEquals(0, OptionalUtility.readDuration(props, "c"));
        assertEquals(0, OptionalUtility.readDuration(props, "d"));
    }
}
