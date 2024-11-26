package calculator.operators;

import calculator.State;

public class Digit extends Operator {
	private final int digit;

	/**
	 * Append digit
	 *
	 * @param state the calculator state
	 * @param digit the digit
	 */
	public Digit(State state, int digit) {
		super(state);
		this.digit = digit;
	}

	@Override
	public void execute() {
		if (hasError()) return;

		if (getState().hasCalculatedValue()) {
			getState().pushCurrentValue();
			getState().clearCurrentValue();
		}

		getState().addDigit(digit);
	}
}
