package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();

	private StringBuilder pendingCurrentValue = new StringBuilder("0");
	private boolean hasDecimalPoint = false;
	private boolean isCalculatedValue = false;
	private boolean isDefaultValue = true;

	private Double memory = null;
	private boolean error = false;

	// User input
	public void addDigit(int digit) {
		if (hasCalculatedValue()) {
			pushValue(getCurrentValue());
			isCalculatedValue = false;
		}

		if (pendingCurrentValue.toString().equals("0")) {
			pendingCurrentValue.deleteCharAt(0);
		}

		pendingCurrentValue.append(digit);
		isDefaultValue = false;
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

		// Implicitly add a zero if the first character is a decimal point
		if (pendingCurrentValue.isEmpty()) {
			pendingCurrentValue.append('0');
		}

		hasDecimalPoint = true;
		pendingCurrentValue.append('.');
	}

	public String getCurrentTextValue() {
		return pendingCurrentValue.isEmpty() ? "0" : pendingCurrentValue.toString();
	}

	public void clearCurrentValue() {
		pendingCurrentValue = new StringBuilder("0");
		hasDecimalPoint = false;
		isCalculatedValue = false;
		isDefaultValue = true;
	}

	public boolean hasCalculatedValue() {
		return isCalculatedValue;
	}

	public boolean hasDefaultValue() {
		return isDefaultValue;
	}

	public double getCurrentValue() {
		return Double.parseDouble(pendingCurrentValue.toString());
	}

	public void setCurrentValue(double currentValue) {
		pendingCurrentValue = new StringBuilder(String.valueOf(currentValue));
		isDefaultValue = false;
		isCalculatedValue = true;
	}

	// Memory
	public void setMemory(double value) {
		this.memory = value;
	}

	public Double getMemory() {
		return memory;
	}

	public void clearMemory() {
		this.memory = null;
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

	public int stackSize() {
		return values.size();
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
