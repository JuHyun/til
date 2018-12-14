import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class UserInputTest {

    @Test
    public void numericInput() {
        UserInput.TextInput input = new UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');

        assertThat(input.getValue(), equalTo("10"));
    }
}