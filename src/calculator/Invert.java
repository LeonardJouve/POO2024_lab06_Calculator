package calculator;

public class Invert extends UnaryOperator{
	public Invert(State state) {
		super(state);
	}

	@Override
	public double operate(double operand) {
		if (operand == 0) getState().raiseError();

		return 1 / operand;
	}
}
