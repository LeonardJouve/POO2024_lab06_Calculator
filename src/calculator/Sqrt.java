package calculator;

public class Sqrt extends UnaryOperator{
	public Sqrt(State state) {
		super(state);
	}

	@Override
	public double operate(double operand) {
		if (operand < 0) getState().raiseError();

		return Math.sqrt(operand);
	}
}
