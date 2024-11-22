package calculator.operators;

import calculator.State;

public class MemoryStore extends Operator {
    public MemoryStore(State state) {
        super(state);
    }

    @Override
    public void execute() {
        if (getState().hasDefaultValue() && getState().stackIsEmpty())
            getState().raiseError();

        if (getState().hasError())
            return;

        double value = getState().hasDefaultValue() ?
                getState().popValue() :
                getState().getCurrentValue();

        getState().setMemory(value);
        getState().clearCurrentValue();
    }
}
