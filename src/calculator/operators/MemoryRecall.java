package calculator.operators;

import calculator.State;

public class MemoryRecall extends Operator {
    public MemoryRecall(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Double value = getState().getMemory();

        if (getState().hasError()) return;

        getState().setCurrentValue(value == null ? 0 : value);
    }
}
