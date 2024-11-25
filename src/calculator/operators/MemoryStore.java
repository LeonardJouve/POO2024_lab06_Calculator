package calculator.operators;

import calculator.State;

public class MemoryStore extends Operator {
    /**
     * Memory store
     *
     * @param state the calculator state
     */
    public MemoryStore(State state) {
        super(state);
    }

    @Override
    public void execute() {
        if (getState().hasError()) return;

        double value = getState().getCurrentValue();

        getState().setMemory(value);
        getState().clearCurrentValue();
    }
}
