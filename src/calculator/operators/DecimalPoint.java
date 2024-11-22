package calculator.operators;

import calculator.State;

public class DecimalPoint extends Operator {

	public DecimalPoint(State state) {
		super(state);
	}

	@Override
	public void execute() {
		if (hasError()) return;

		getState().addDecimalPoint();
	}
}
