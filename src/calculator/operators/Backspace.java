package calculator.operators;

import calculator.State;

public class Backspace extends Operator {

	public Backspace(State state) {
		super(state);
	}

	@Override
	public void execute() {
		getState().popDigit();
	}
}
