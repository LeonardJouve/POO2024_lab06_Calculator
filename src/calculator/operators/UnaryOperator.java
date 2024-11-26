package calculator.operators;

import calculator.State;

public abstract class UnaryOperator extends Operator {
    /**
     * Abstract operator with one operand
     *
     * @param state the calculator state
     */
    public UnaryOperator(State state) {
        super(state);
    }

    /**
     * Calculate the operation result
     *
     * @param operand the operand
     * @return the operation result
     */
    protected abstract double operate(double operand);

    @Override
    public void execute() {
        if (hasError()) return;

        double operand = getState().getCurrentValue();

        getState().setCalculatedValue(operate(operand));
    }
}
