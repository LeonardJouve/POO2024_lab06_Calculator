package calculator.operators;

import calculator.State;

abstract class Operator {
	private final State state;

	public Operator(State state) {
		this.state = state;
	}

	abstract void execute();

	protected State getState() {
		return state;
	}
}
