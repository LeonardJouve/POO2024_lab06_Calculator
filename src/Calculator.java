import calculator.State;
import calculator.operators.*;

import java.util.*;

public class Calculator {

	public static final String EXIT_CODE = "exit";
	public static final List<String> DISPLAY_BLOCKING_OPS = List.of("CE", "C");

	public static void main(String[] args) {
		State state = new State();
		Map<String, Operator> operators = operatorSetup(state);

		Scanner scanner = new Scanner(System.in);
		String input;
		while (!(input = scanner.next()).equals(EXIT_CODE)) {
			try {
				double value = Double.parseDouble(input);

				state.pushCurrentValue();

				state.setCurrentValue(value);
			} catch (NumberFormatException e) {
				operators.get(input).execute();
			}

			if (state.hasError()) continue;

			if (!DISPLAY_BLOCKING_OPS.contains(input)) {
				System.out.print(state.getCurrentValue() + " ");
			}
			for (String stackElement : state.getStackAsStringArray()) {
				System.out.print(stackElement + " ");
			}
			System.out.println();
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
