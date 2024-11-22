package calculator.operators;

import calculator.State;

public class AddToStack extends Operator {
	/**
	 * Push values to the stack
	 *
	 * @param state the calculator state
	 */
	public AddToStack(State state) {
		super(state);
	}

	@Override
	public void execute() {
		if (hasError()) return;

		getState().pushValue(getState().getCurrentValue());
		getState().clearCurrentValue();
	}
}
