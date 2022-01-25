package calculator.domain;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private Calculator() {
    }

    public static double run(List<String> expression) {
        Stack<String> symbols = new Stack<>();

        for (int i = expression.size() - 1; i >= 0; i--) {
            symbols.push(expression.get(i));
        }

        while (symbols.size() > 1) {
            double prev = convertToNumber(symbols.pop());
            Operation operator = Operation.from(symbols.pop());
            double next = convertToNumber(symbols.pop());

            double result = operator.apply(prev, next);

            symbols.push(String.valueOf(result));
        }

        return Double.parseDouble(symbols.pop());
    }

    private static double convertToNumber(String symbol) {
        return Double.parseDouble(symbol);
    }
}
