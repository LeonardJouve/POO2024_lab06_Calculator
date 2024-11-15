package calculator;

public class DecimalPoint extends Operator {

	public DecimalPoint(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().addDecimalPoint();
	}
}
