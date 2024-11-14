package calculator.operator;

import calculator.State;

public class Value extends Operator {
    private int value;

    public Value(State state, int value) {
        super(state);
        this.value = value;
    }

    @Override
    public void execute() {
        getState().addDigit(value);
    }
}
