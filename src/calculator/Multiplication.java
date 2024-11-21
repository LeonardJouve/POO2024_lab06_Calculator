package calculator;

public class Multiplication extends BinaryOperator {
	public Multiplication(State state) {
		super(state);
	}

	@Override
	public double operate(double leftOperand, double rightOperand) {
		return leftOperand * rightOperand;
	}
}
