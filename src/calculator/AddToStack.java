package calculator;

public class AddToStack extends Operator {

	public AddToStack(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().acceptCurrentValue();

		getState().pushValue(getState().getCurrentValue());
		getState().clearInput();
		getState().clearCurrentValue();
	}
}
