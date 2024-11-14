package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();
	private double currentValue = 0;
	private StringBuilder pendingCurrentValue = new StringBuilder();
	private Double memory = null;

	public double popValue() {
		return values.pop();
	}

	public void pushValue(Double value) {
		values.push(value);
	}

	public String[] toStringArray() {
		return values.toStringArray();
	}

	public int size() {
		return values.size();
	}

	public boolean hasEmptyStack() {
		return values.isEmpty();
	}

	public String getPendingCurrentValue() {
		return pendingCurrentValue.toString();
	}

	public void acceptCurrentValue() {
		currentValue = Double.parseDouble(pendingCurrentValue.toString());
		pushValue(currentValue);
		pendingCurrentValue = new StringBuilder();
	}

	public void clearCurrentValue() {
		currentValue = 0;
		pendingCurrentValue = new StringBuilder();
	}

	public void addDigit(int digit) {
		if (pendingCurrentValue.toString().equals("0") && digit == 0) {
			return;
		}
		pendingCurrentValue.append(digit);
	}

	public void removeDigit() {
		pendingCurrentValue.deleteCharAt(pendingCurrentValue.length() - 1);
	}

	public void addDecimalPoint() {
		if (pendingCurrentValue.charAt(pendingCurrentValue.length() - 1) == '.') {
			return;
		}

		pendingCurrentValue.append(".");
	}

	public void invertSign() {
		if (!pendingCurrentValue.isEmpty() && pendingCurrentValue.charAt(0) == '-') {
			pendingCurrentValue.deleteCharAt(0);
		} else {
			pendingCurrentValue.insert(0, "-");
		}
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public void setMemory(Double value) {
		this.memory = value;
	}

	public Double getMemory() {
		return memory;
	}

	public void clearError() {
		// TODO: add error handling
		currentValue = 0;
		pendingCurrentValue = new StringBuilder();
	}

	public void clear() {
		clearError();

		values = new Stack<>();
		memory = null;
	}
}
