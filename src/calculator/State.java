package calculator;

import util.Stack;

public class State {
	private Stack<Double> values = new Stack<>();

	private Double currentValue = null;

	private StringBuilder pendingCurrentValue = new StringBuilder();
	boolean hasDecimalPoint = false;

	private Double memory = null;
	private boolean error = false;



	// User input
	public void addDigit(int digit) {
		if (currentValue != null) {
			pushValue(currentValue);
			currentValue = null;
		}

		if (pendingCurrentValue.toString().equals("0")) {
			pendingCurrentValue.deleteCharAt(0);
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

	public String getCurrentTextValue() {
		return pendingCurrentValue.isEmpty() ? "0" : pendingCurrentValue.toString();
	}

	public void acceptCurrentValue() {
		try {
			double value = Double.parseDouble(pendingCurrentValue.toString());

			setCurrentValue(value);
		} catch (NumberFormatException e) {
			raiseError();
		}

		clearInput();
	}

	public void clearCurrentValue() {
		currentValue = null;
	}

	public boolean currentValueIsEmpty() {
		return currentValue == null;
	}

	public boolean hasInput() {
		return !pendingCurrentValue.isEmpty();
	}

	public void clearInput() {
		pendingCurrentValue = new StringBuilder();
		hasDecimalPoint = false;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
		pendingCurrentValue = new StringBuilder(String.valueOf(currentValue));
	}

	// Stack
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
