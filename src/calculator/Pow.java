package calculator;

public class Pow extends UnaryOperator {

	int power;

	public Pow(State state, int power) {
		super(state);

		this.power = power;
	}

	@Override
	public double operate(double operand) {
		return Math.pow(operand, power);
	}
}
