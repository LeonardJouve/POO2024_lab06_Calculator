package calculator;

public class Addition extends Operator {
	public Addition(State state) {
		super(state);
	}

	@Override
	void execute() {
		if (getState().stackIsEmpty() || (getState().stackSize() < 2 && !getState().hasInput())) {
			getState().raiseError();
		}

		if (hasError()) return;

		double a;
		if (getState().hasInput()) {
			getState().acceptCurrentValue();
			a = getState().getCurrentValue();
		} else {
			a = getState().popValue();
		}

		double b = getState().popValue();

		getState().setCurrentValue(a + b);
	}
}
