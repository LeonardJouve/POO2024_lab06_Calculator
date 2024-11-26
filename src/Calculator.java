import calculator.State;
import calculator.operators.*;

import java.util.*;

public class Calculator {

	public static final String EXIT_CODE = "exit";
	public static final String ERROR_CODE = "error";
	public static final List<String> DISPLAY_BLOCKING_OPS = List.of("CE", "C");

	public static void main(String[] args) {
		State state = new State();
		Map<String, Operator> operators = operatorSetup(state);

		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("> ");
		while (!(input = scanner.next()).equals(EXIT_CODE)) {
			try {
				double value = Double.parseDouble(input);

				if (state.hasCalculatedValue()) {
					state.pushCurrentValue();
					state.clearCurrentValue();
				}

				state.setCalculatedValue(value);
			} catch (NumberFormatException e) {
				Operator operator = operators.get(input);
				if (operator == null) {
					state.raiseError();
				} else {
					operator.execute();
				}
			}

			if (state.hasError()) {
				System.out.println(ERROR_CODE);
				System.out.print("> ");
				state.clearCurrentValue();
				continue;
			}

			if (!DISPLAY_BLOCKING_OPS.contains(input)) {
				System.out.print(state.getCurrentValue() + " ");
			}
			for (String stackElement : state.getStackAsStringArray()) {
				System.out.print(stackElement + " ");
			}
			System.out.println();
			System.out.print("> ");
		}
	}

	public static Map<String, Operator> operatorSetup(State state) {
		Map<String, Operator> operators = new HashMap<>();

		operators.put("+", new Addition(state));
		operators.put("-", new Subtraction(state));
		operators.put("*", new Multiplication(state));
		operators.put("/", new Division(state));

		operators.put("sqrt", new Sqrt(state));
		operators.put("x^2", new Pow(state, 2));
		operators.put("1/x", new Invert(state));
		operators.put("+/-", new InvertSign(state));

		operators.put("CE", new Clear(state, true));
		operators.put("C", new Clear(state, false));
		operators.put("MS", new MemoryStore(state));
		operators.put("MR", new MemoryRecall(state));

		return operators;
	}
}
