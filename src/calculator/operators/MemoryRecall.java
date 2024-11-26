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
        if (getState().hasError()) return;

        double value = getState().getMemory();

        getState().setCalculatedValue(value);
    }
}
