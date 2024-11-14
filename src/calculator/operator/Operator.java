package calculator.operator;

import calculator.State;

public abstract class Operator {
	private final State state;

	public Operator(State state) {
		this.state = state;
	}

	public abstract void execute();

	protected State getState() {
		return state;
	}
}
