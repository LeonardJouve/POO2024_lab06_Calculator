package calculator.operator;

import calculator.State;

public class Dot extends Operator {
    public Dot(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().addDecimalPoint();
    }
}
