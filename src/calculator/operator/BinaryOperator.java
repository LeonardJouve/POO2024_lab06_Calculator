package calculator.operator;

import calculator.State;

import javax.swing.*;
import java.util.NoSuchElementException;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(State state) {
        super(state);
    }

    public abstract double operate(double leftOperand, double rightOperand);

    public void execute() {
        if (getState().size() < 2) throw new NoSuchElementException();

        double rightOperand = getState().popValue();
        double leftOperand = getState().popValue();
        getState().pushValue(operate(leftOperand, rightOperand));
    }
}
