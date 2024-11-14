package calculator.operator;

import calculator.State;

public class Square extends UnaryOperator {
    public Square(State state) {
        super(state);
    }

    @Override
    public double operate(double operand) {
        return Math.pow(operand, 2);
    }
}
