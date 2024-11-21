package calculator;

public class Addition extends BinaryOperator {
	public Addition(State state) {
		super(state);
	}

	@Override
	public double operate(double leftOperand, double rightOperand) {
		return leftOperand + rightOperand;
	}
}
