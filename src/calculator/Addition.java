package calculator;

public class Addition extends Operator {
	public Addition(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().acceptCurrentValue();
		if (getState().stackIsEmpty() || getState().currentValueIsEmpty()) {
			getState().raiseError();
			return;
		}

		if (hasError()) return;

		double a = getState().getCurrentValue();
		double b = getState().popValue();

		getState().setCurrentValue(a + b);
	}
}
