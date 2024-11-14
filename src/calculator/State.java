package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();
	private double currentValue = 0;
	private StringBuilder pendingCurrentValue = new StringBuilder();
	boolean hasDecimalPoint = false;
	private double memory = 0;

	public double popValue() {
		return values.pop();
	}

	public void pushValue(Double value) {
		values.push(value);
	}

	public String[] toStringArray() {
		return values.toStringArray();
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
		hasDecimalPoint = false;
		pendingCurrentValue = new StringBuilder();
	}

	public void clearCurrentValue() {
		currentValue = 0;
		pendingCurrentValue = new StringBuilder();
	}

	public void addDigit(int digit) {
		pendingCurrentValue.append(digit);
	}

	public void removeDigit() {
		if (pendingCurrentValue.charAt(pendingCurrentValue.length() - 1) == '.') {
			hasDecimalPoint = false;
		}

		pendingCurrentValue.deleteCharAt(pendingCurrentValue.length() - 1);
	}

	public void addDecimalPoint() {
		if (pendingCurrentValue.charAt(pendingCurrentValue.length() - 1) == '.') {
			return;
		}

		hasDecimalPoint = true;
		pendingCurrentValue.append(".");
	}

	public void negateCurrentValue() {
		if (pendingCurrentValue.charAt(0) == '-') {
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

	public void setMemory(double value) {
		this.memory = value;
	}

	public double getMemory() {
		return memory;
	}

	public void clearError() {
		// TODO: add error handling
		currentValue = 0;
		pendingCurrentValue = new StringBuilder();
		hasDecimalPoint = false;
	}

	public void clear() {
		clearError();

		values = new Stack<>();
		// TODO: is it necessary to remove memorized value?
	}
}
