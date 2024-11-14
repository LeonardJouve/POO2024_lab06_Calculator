package calculator.operator;

import calculator.State;

public class Negate extends Operator {
    public Negate(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().negateCurrentValue();
    }
}
