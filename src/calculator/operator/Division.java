package calculator.operator;

import calculator.State;

public class Division extends BinaryOperator {
    public Division(State state) {
        super(state);
    }

    @Override
    public double operate(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
