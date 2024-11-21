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

        double right;
        if (getState().hasInput()) {
            getState().acceptCurrentValue();
            right = getState().getCurrentValue();
        } else {
            right = getState().popValue();
        }

        double left = getState().popValue();

        getState().setCurrentValue(operate(left, right));
    }
}
