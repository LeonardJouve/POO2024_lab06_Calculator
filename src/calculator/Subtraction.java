package calculator;

public class Subtraction extends BinaryOperator{
	public Subtraction(State state) {
		super(state);
	}

	@Override
	public double operate(double leftOperand, double rightOperand) {
		return leftOperand - rightOperand;
	}
}
