package calculator.operators;

import calculator.State;

public class DecimalPoint extends Operator {
	/**
	 * Add decimal point
	 *
	 * @param state the calculator state
	 */
	public DecimalPoint(State state) {
		super(state);
	}

	@Override
	public void execute() {
		if (hasError()) return;

		getState().addDecimalPoint();
	}
}
