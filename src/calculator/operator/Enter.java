package calculator.operator;

import calculator.State;

public class Enter extends Operator {
    public Enter(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().acceptCurrentValue();
    }
}
