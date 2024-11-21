package calculator;

public class InvertSign extends UnaryOperator {
	public InvertSign(State state) {
		super(state);
	}

	@Override
	public double operate(double operand) {
		return -1 * operand;
	}
}
