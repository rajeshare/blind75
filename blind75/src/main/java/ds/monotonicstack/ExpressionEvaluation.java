package ds.monotonicstack;

import java.util.Stack;

public class ExpressionEvaluation {

    static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }

        if (op == '*' || op == '/') {
            return 2;
        }

        return 0;
    }

    static int applyOperation(int a, int b, char op) {

        switch (op) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':
                return a / b;

            default:
                return 0;
        }
    }

    static int evaluate(String expression) {

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // If digit
            if (Character.isDigit(ch)) {

                int number = 0;

                while (i < expression.length()
                        && Character.isDigit(expression.charAt(i))) {

                    number = number * 10
                            + (expression.charAt(i) - '0');

                    i++;
                }

                i--;

                numbers.push(number);
            }

            // Opening bracket
            else if (ch == '(') {

                operators.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (operators.peek() != '(') {

                    int b = numbers.pop();
                    int a = numbers.pop();

                    char op = operators.pop();

                    numbers.push(applyOperation(a, b, op));
                }

                // Remove '('
                operators.pop();
            }

            // Operator
            else {

                while (!operators.isEmpty()
                        && operators.peek() != '('
                        && precedence(operators.peek())
                        >= precedence(ch)) {

                    int b = numbers.pop();
                    int a = numbers.pop();

                    char op = operators.pop();

                    numbers.push(applyOperation(a, b, op));
                }

                operators.push(ch);
            }
        }

        // Process remaining operators
        while (!operators.isEmpty()) {

            int b = numbers.pop();
            int a = numbers.pop();

            char op = operators.pop();

            numbers.push(applyOperation(a, b, op));
        }

        return numbers.pop();
    }

    public static void main(String[] args) {

        String expression = "2 * (3 + 4) - 5";

        System.out.println(evaluate(expression));
    }
}