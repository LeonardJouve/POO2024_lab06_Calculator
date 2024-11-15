package calculator;

public class DecimalPoint extends Operator {

	public DecimalPoint(State state) {
		super(state);
	}

	@Override
	void execute() {
		if (hasError()) return;

		getState().addDecimalPoint();
	}
}
