package calculator.operator;

import calculator.State;

public class SquareRoot extends UnaryOperator {
    public SquareRoot(State state) {
        super(state);
    }

    @Override
    public double operate(double operand) {
        return Math.sqrt(operand);
    }
}
