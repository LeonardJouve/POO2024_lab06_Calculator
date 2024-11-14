package calculator.operator;

import calculator.State;

import java.util.NoSuchElementException;

public class MemoryStore extends Operator {
    public MemoryStore(State state) {
        super(state);
    }

    @Override
    public void execute() {
        if (getState().hasEmptyStack()) throw new NoSuchElementException();

        double value = getState().popValue();
        getState().setMemory(value);
    }
}
