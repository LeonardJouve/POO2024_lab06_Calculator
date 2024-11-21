package calculator;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double leftOperand, double rightOperand);

    @Override
    void execute() {
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
