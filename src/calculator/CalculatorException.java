package calculator;

public class CalculatorException extends Exception {
    public CalculatorException(Type type) {
        super(type.getValue());
    }

    public static enum Type {
        TEST("dwdw"),
        TOTO("da");

        private final String value;
        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


}
