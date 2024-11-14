package calculator.operator;

import calculator.State;

public class Invert extends UnaryOperator {
    public Invert(State state) {
        super(state);
    }

    @Override
    public double operate(double operand) {
        return 1 / operand;
    }
}
