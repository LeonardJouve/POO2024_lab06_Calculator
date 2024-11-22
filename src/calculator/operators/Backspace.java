package calculator.operators;

import calculator.State;

public class Backspace extends Operator {
	/**
	 * Remove last digit or decimal point
	 *
	 * @param state the calculator state
	 */
	public Backspace(State state) {
		super(state);
	}

	@Override
	public void execute() {
		getState().popDigit();
	}
}
