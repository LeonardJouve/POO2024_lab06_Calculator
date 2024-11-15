package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();
	private Double currentValue = null;
	private StringBuilder pendingCurrentValue = new StringBuilder();
	boolean hasDecimalPoint = false;
	private double memory = 0;

	public double popValue() {
		return values.pop();
	}

	public void pushValue(Double value) {
		values.push(value);
	}

	public void acceptCurrentValue() {
		currentValue = Double.parseDouble(pendingCurrentValue.toString());
		pendingCurrentValue = new StringBuilder();
	}

	public void clearCurrentValue() {
		currentValue = null;
		pendingCurrentValue = new StringBuilder();
	}

	public void addDigit(int digit) {
		if (currentValue != null) {
			pushValue(currentValue);
			currentValue = null;
		}

		pendingCurrentValue.append(digit);
	}

	public void removeDigit() {
		if (pendingCurrentValue.charAt(pendingCurrentValue.length() - 1) == '.') {
			hasDecimalPoint = false;
		}

		pendingCurrentValue.deleteCharAt(pendingCurrentValue.length() - 1);
	}

	public void addDecimalPoint() {
		hasDecimalPoint = true;
		pendingCurrentValue.append(".");
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
		currentValue = null;
		pendingCurrentValue = new StringBuilder();
		hasDecimalPoint = false;
	}

	public void clear() {
		clearError();

		values = new Stack<>();
		// TODO: is it necessary to remove memorized value?
	}
}
