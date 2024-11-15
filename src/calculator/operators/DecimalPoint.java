package calculator.operators;

import calculator.State;

public class DecimalPoint extends Operator {

	public DecimalPoint(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().addDecimalPoint();
	}
}
