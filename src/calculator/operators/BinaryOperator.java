package calculator.operators;

import calculator.State;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    protected abstract double operate(double leftOperand, double rightOperand);

    @Override
    public void execute() {
        if (getState().stackIsEmpty() || (getState().hasDefaultValue() && getState().stackSize() < 2)) {
            getState().raiseError();
        }

        if (hasError()) return;

        double leftOperand;
        if (getState().hasDefaultValue()) {
            leftOperand = getState().popValue();
        } else {
            leftOperand = getState().getCurrentValue();
        }

        double rightOperand = getState().popValue();

        getState().setCurrentValue(operate(leftOperand, rightOperand));
    }
}
