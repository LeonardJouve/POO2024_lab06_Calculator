package calculator;

public class Addition extends Operator {
	public Addition(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().acceptCurrentValue();

		double a = getState().getCurrentValue();
		double b = getState().popValue();

		getState().setCurrentValue(a + b);
	}
}
