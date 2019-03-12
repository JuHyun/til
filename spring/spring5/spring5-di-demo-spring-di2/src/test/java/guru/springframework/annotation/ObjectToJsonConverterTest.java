package guru.springframework.annotation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectToJsonConverterTest {

    private ObjectToJsonConverter objectToJsonConverter;

    @BeforeEach
    public void setUp() {
        objectToJsonConverter = new ObjectToJsonConverter();
    }

    @Test
    public void givenObjectNotSerializedThenExceptionThrown() {
        Object object = new Object();
        assertThrows(JsonSerializationException.class, () -> {
            objectToJsonConverter.convertToString(object);
        });
    }

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("soufiane", "cheouati", "34");
        String jsonString = objectToJsonConverter.convertToString(person);
        assertEquals("{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}", jsonString);
    }
}
