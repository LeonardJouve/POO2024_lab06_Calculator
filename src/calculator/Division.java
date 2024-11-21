package calculator;

public class Division extends BinaryOperator {
	public Division(State state) {
		super(state);
	}

	@Override
	public double operate(double leftOperand, double rightOperand) {
		if (rightOperand == 0) getState().raiseError();

		return leftOperand / rightOperand;
	}
}
