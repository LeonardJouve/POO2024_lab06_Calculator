package calculator.operators;

import calculator.State;

public class Addition extends BinaryOperator {
	public Addition(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		return leftOperand + rightOperand;
	}
}
