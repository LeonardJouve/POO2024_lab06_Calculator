package calculator.operators;

import calculator.State;

public class MemoryRecall extends Operator {
    /**
     * Memory recall
     *
     * @param state the calculator state
     */
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
