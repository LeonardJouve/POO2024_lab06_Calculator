package calculator.operator;

import calculator.State;

public class InvertSign extends Operator {
    public InvertSign(State state) {
        super(state);
    }

    @Override
    public void execute() {
        getState().invertSign();
    }
}
