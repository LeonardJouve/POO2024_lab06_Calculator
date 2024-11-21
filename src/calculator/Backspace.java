package calculator;

public class Backspace extends Operator{

	public Backspace(State state) {
		super(state);
	}

	@Override
	void execute() {
		getState().popDigit();
	}
}
