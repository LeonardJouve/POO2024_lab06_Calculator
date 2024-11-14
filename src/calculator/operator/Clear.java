package calculator.operator;

import calculator.State;

public class Clear extends Operator {
    public Clear(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().clear();
    }
}
