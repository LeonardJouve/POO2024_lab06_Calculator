package calculator;

public class AddToStack extends Operator {

	public AddToStack(State state) {
		super(state);
	}

	@Override
	void execute() {
		if (hasError()) return;

		getState().pushValue(getState().getCurrentValue());
		getState().clearCurrentValue();
	}
}
