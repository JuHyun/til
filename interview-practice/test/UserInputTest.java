import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserInputTest {

    @Test
    public void numericInput() {
        UserInput.TextInput input = new UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');

        assertEquals("10", input.getValue());
    }
}
