package item3.staticfinalfield;

import static org.junit.jupiter.api.Assertions.*;

import item3.staticfinalfield.Elvis;
import org.junit.jupiter.api.Test;

class ElvisTest {

    @Test
    public void singleton() {
        Elvis instance1 = Elvis.INSTANCE;
        Elvis instance2 = Elvis.INSTANCE;
        Elvis instance3 = Elvis.INSTANCE;

        assertEquals(instance1, instance2);
        assertEquals(instance2, instance3);
        assertEquals(instance3, instance1);
    }
}
