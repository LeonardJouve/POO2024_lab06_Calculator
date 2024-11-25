package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();

	private StringBuilder pendingCurrentValue = new StringBuilder("0");
	private boolean hasDecimalPoint = false;
	private boolean hasCalculatedValue = false;

	private double memory = 0;
	private boolean error = false;

	// User input
	public void addDigit(int digit) {
		if (hasCalculatedValue()) {
			pushValue(getCurrentValue());
			hasCalculatedValue = false;
		}

		if (pendingCurrentValue.toString().equals("0")) {
			pendingCurrentValue.deleteCharAt(0);
		}

		pendingCurrentValue.append(digit);
	}

	public void popDigit() {
		if (pendingCurrentValue.charAt(pendingCurrentValue.length() - 1) == '.') {
			hasDecimalPoint = false;
		}

		pendingCurrentValue.deleteCharAt(pendingCurrentValue.length() - 1);

		if (pendingCurrentValue.isEmpty()) {
			pendingCurrentValue.append("0");
		}
	}

	public void addDecimalPoint() {
		if (hasDecimalPoint) return;

		hasDecimalPoint = true;
		pendingCurrentValue.append('.');
	}

	public String getCurrentTextValue() {
		return pendingCurrentValue.toString();
	}

	public void clearCurrentValue() {
		pendingCurrentValue = new StringBuilder("0");
		hasDecimalPoint = false;
		hasCalculatedValue = false;
	}

	public boolean hasCalculatedValue() {
		return hasCalculatedValue;
	}

	public double getCurrentValue() {
		return Double.parseDouble(pendingCurrentValue.toString());
	}

	public void setCurrentValue(double newValue) {
		pendingCurrentValue = new StringBuilder(String.valueOf(newValue));
		hasCalculatedValue = true;
	}

	// Memory
	public void setMemory(double value) {
		this.memory = value;
	}

	public double getMemory() {
		return memory;
	}

	public void clearMemory() {
		this.memory = 0;
	}

	// Stack
	public double popValue() {
		return values.pop();
	}

	public void pushValue(Double value) {
		values.push(value);
	}

	public void clearStack() {
		values = new Stack<>();
	}

	public boolean stackIsEmpty() {
		return values.isEmpty();
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

	// Error
	public void clearError() {
		error = false;
	}

	public void raiseError() {
		error = true;
	}

	public boolean hasError() {
		return error;
	}
}
