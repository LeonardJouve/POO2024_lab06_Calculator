package calculator.operators;

import calculator.State;

public class Clear extends Operator {
	private final boolean keepStack;

	/**
	 * Clear current value, memory, error
	 *
	 * @param state the calculator state
	 * @param keepStack is the stack kept after clear
	 */
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
