package calculator;

public abstract class UnaryOperator extends Operator {
    public UnaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double operand);

    @Override
    public void execute() {
        if (getState().hasDefaultValue() && getState().stackIsEmpty()) {
            getState().raiseError();
        }

        if (hasError()) return;

        double operand;
        if (getState().hasDefaultValue()) {
            operand = getState().getCurrentValue();
        } else {
            operand = getState().popValue();
        }

        getState().pushValue(operate(operand));
    }
}
