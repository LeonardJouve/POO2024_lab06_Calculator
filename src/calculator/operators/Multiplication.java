package calculator.operators;

import calculator.State;

public class Multiplication extends BinaryOperator {
	public Multiplication(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		return leftOperand * rightOperand;
	}
}
