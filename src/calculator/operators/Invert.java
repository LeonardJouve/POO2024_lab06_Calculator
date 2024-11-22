package calculator.operators;

import calculator.State;

public class Invert extends UnaryOperator {
	public Invert(State state) {
		super(state);
	}

	@Override
	protected double operate(double operand) {
		if (operand == 0) getState().raiseError();

		return 1 / operand;
	}
}
