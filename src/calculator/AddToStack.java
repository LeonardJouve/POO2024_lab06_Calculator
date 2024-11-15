package calculator;

public class AddToStack extends Operator {

	public AddToStack(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().acceptCurrentValue();
	}
}
