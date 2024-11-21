package calculator;

public class Digit extends Operator {
	int digit;

	public Digit(State state, int digit) {
		super(state);
		this.digit = digit;
	}

	@Override
	void execute() {
		if (hasError()) return;

		if (getState().hasCalculatedValue()) {
			getState().pushValue(getState().getCurrentValue());
			getState().clearCurrentValue();
		}

		getState().addDigit(digit);
	}
}
