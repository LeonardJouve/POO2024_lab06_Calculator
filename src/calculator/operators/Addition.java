package calculator.operators;

import calculator.State;

public class Addition extends BinaryOperator {
	/**
	 * Addition operator
	 *
	 * @param state the calculator state
	 */
	public Addition(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		return leftOperand + rightOperand;
	}
}
