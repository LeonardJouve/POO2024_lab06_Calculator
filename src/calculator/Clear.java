package calculator;

public class Clear extends Operator {

	private final boolean keepStack;

	public Clear(State state, boolean keepStack) {
		super(state);

		this.keepStack = keepStack;
	}

	@Override
	void execute() {
		getState().clearInput();
		getState().clearCurrentValue();
		getState().clearError();

		if (!keepStack) {
			getState().clearStack();
		}
	}
}
