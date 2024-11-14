package calculator.operator;

import calculator.State;

public abstract class UnaryOperator extends Operator {
    public UnaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double operand);

    @Override
    public void execute() {
        double operand = getState().popValue();

        getState().pushValue(operate(operand));
    }
}
