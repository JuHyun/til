public class UserInput {
    public static class TextInput {
        protected StringBuilder input = new StringBuilder();

        public void add(char c) {
            input.append(c);
        }

        public String getValue() {
            return input.toString();
        }
    }

    public static class NumericInput extends TextInput {

        public NumericInput() {
            super();
        }

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                input.append(c);
            }
        }
    }

    public static void main(String[] args) {
        //TextInput input = new NumericInput();
        //input.add('1');
        //input.add('a');
        //input.add('0');
        //System.out.println(input.getValue());
    }
}
