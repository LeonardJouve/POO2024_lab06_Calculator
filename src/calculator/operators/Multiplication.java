package calculator.operators;

import calculator.State;

public class Multiplication extends BinaryOperator {
	/**
	 * Multiplication operator
	 *
	 * @param state the calculator state
	 */
	public Multiplication(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		return leftOperand * rightOperand;
	}
}
