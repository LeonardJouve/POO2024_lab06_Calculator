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

		Double currentValue = getState().getCurrentValue();
		if (currentValue != null) {
			getState().pushValue(currentValue);
			getState().clearCurrentValue();
			getState().clearInput();
		}

		getState().addDigit(digit);
	}
}
