package calculator;

abstract class Operator {
	private final State state;

	public Operator(State state) {
		this.state = state;
	}

	abstract void execute();

	protected State getState() {
		return state;
	}

	protected final boolean hasError() {
		if (getState().hasError()) {
			System.err.println("The calculator is in an error state.");

			return true;
		} else return false;
	}
}
