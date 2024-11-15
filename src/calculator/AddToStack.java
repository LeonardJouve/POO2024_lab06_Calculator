package calculator;

public class AddToStack extends Operator {

	public AddToStack(State state) {
		super(state);
	}

	@Override
	void execute() {
		double value = Double.parseDouble(getState().getCurrentTextValue());
		getState().clearInput();

		getState().pushValue(value);
	}
}
