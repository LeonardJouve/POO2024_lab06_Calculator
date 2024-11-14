package calculator.operator;

import calculator.State;

public class BackSpace extends Operator {
    public BackSpace(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().removeDigit();
    }
}
