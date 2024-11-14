package calculator.operator;

import calculator.State;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double leftOperand, double rightOperand);

    public void execute() {
        double rightOperand = getState().popValue();
        double leftOperand = getState().popValue();
        getState().pushValue(operate(leftOperand, rightOperand));
    }
}
