package calculator;

public class Digit extends Operator {
	int digit;

	public Digit(State state, int digit) {
		super(state);
	}

	@Override
	void execute() {
		getState().addDigit(digit);
	}
}
