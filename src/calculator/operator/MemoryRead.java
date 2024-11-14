package calculator.operator;

import calculator.State;

import java.util.NoSuchElementException;

public class MemoryRead extends Operator {
    public MemoryRead(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Double value = getState().getMemory();

        if (value == null) throw new NoSuchElementException();

        getState().pushValue(value);
    }
}
