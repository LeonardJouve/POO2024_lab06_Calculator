package calculator.operators;

import calculator.State;

public class Sqrt extends UnaryOperator {
	/**
	 * Square root operator
	 *
	 * @param state the calculator state
	 */
	public Sqrt(State state) {
		super(state);
	}

	@Override
	protected double operate(double operand) {
		if (operand < 0) getState().raiseError();

		return Math.sqrt(operand);
	}
}
