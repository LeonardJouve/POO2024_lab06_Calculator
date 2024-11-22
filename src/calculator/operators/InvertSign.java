package calculator.operators;

import calculator.State;

public class InvertSign extends UnaryOperator {
	public InvertSign(State state) {
		super(state);
	}

	@Override
	protected double operate(double operand) {
		return -1 * operand;
	}
}
