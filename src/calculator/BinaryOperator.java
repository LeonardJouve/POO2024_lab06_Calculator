package calculator;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double leftOperand, double rightOperand);

    @Override
    void execute() {
        if (getState().stackIsEmpty() || (getState().stackSize() < 2 && !getState().hasInput())) {
            getState().raiseError();
        }

        if (hasError()) return;

        double leftOperand;
        if (getState().hasInput()) {
            getState().acceptCurrentValue();
            leftOperand = getState().getCurrentValue();
        } else {
            leftOperand = getState().popValue();
        }

        double rightOperand = getState().popValue();

        getState().setCurrentValue(operate(leftOperand, rightOperand));
    }
}
