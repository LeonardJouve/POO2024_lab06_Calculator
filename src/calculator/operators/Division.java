package calculator.operators;

import calculator.State;

public class Division extends BinaryOperator {
	public Division(State state) {
		super(state);
	}

	@Override
	protected double operate(double leftOperand, double rightOperand) {
		if (rightOperand == 0) getState().raiseError();

		return leftOperand / rightOperand;
	}
}
