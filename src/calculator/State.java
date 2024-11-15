package calculator;

import util.Stack;

import java.util.Arrays;

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

	public String getCurrentTextValue() {
		return pendingCurrentValue.isEmpty() ? "0" : pendingCurrentValue.toString();
	}

	public void clearCurrentValue() {
		currentValue = null;
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
		if (hasDecimalPoint) return;

		// Implicitly add a zero if the first character is a decimal point
		if (pendingCurrentValue.isEmpty()) {
			pendingCurrentValue.append('0');
		}

		hasDecimalPoint = true;
		pendingCurrentValue.append('.');
	}

	public Double getCurrentValue() {
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
		clearCurrentValue();
		pendingCurrentValue = new StringBuilder();
		hasDecimalPoint = false;
	}

	public void clear() {
		clearError();

		values = new Stack<>();
		// TODO: is it necessary to remove memorized value?
	}

	public String[] getStackAsStringArray() {
		String[] result = new String[values.size()];

		int i = 0;
		for (double value : values) {
			result[i] = String.valueOf(value);
			++i;
		}

		return result;
	}
}
