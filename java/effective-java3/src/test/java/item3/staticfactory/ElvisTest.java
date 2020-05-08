package item3.staticfactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ElvisTest {

    @Test
    public void singleton() {
        Elvis instance1 = Elvis.getInstance();
        Elvis instance2 = Elvis.getInstance();
        Elvis instance3 = Elvis.getInstance();

        assertEquals(instance1, instance2);
        assertEquals(instance2, instance3);
        assertEquals(instance3, instance1);
    }
}
