package calculator.operators;

import calculator.State;

public class Subtraction extends BinaryOperator {
	public Subtraction(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		return leftOperand - rightOperand;
	}
}