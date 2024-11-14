package calculator.operator;

import calculator.State;

public class ClearError extends Operator {
    public ClearError(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().clearError();
    }
}
