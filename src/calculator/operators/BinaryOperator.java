package calculator.operators;

import calculator.State;

public abstract class BinaryOperator extends Operator {
    /**
     * Abstract operator with two operands
     *
     * @param state the calculator state
     */
    public BinaryOperator(State state) {
        super(state);
    }

    /**
     * Calculate the operation result
     *
     * @param leftOperand the left operand
     * @param rightOperand the right operand
     * @return the operation result
     */
    protected abstract double operate(double leftOperand, double rightOperand);

    @Override
    public void execute() {
        if (getState().stackIsEmpty()) {
            getState().raiseError();
        }

        if (hasError()) return;

        double left = getState().popValue();
        double right = getState().getCurrentValue();

        getState().setCurrentValue(operate(left, right));
    }
}
