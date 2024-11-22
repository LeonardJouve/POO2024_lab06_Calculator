package calculator.operators;

import calculator.State;

public class Pow extends UnaryOperator {

	int power;

	public Pow(State state, int power) {
		super(state);

		this.power = power;
	}

	@Override
	protected double operate(double operand) {
		return Math.pow(operand, power);
	}
}
