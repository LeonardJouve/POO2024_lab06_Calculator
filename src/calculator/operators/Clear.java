package calculator.operators;

import calculator.State;

public class Clear extends Operator {

	private final boolean keepStack;

	public Clear(State state, boolean keepStack) {
		super(state);

		this.keepStack = keepStack;
	}

	@Override
	public void execute() {
		getState().clearCurrentValue();
		getState().clearMemory();
		getState().clearError();

		if (!keepStack) {
			getState().clearStack();
		}
	}
}