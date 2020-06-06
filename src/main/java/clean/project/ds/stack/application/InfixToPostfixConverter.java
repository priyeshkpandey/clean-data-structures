package clean.project.ds.stack.application;

import clean.project.ds.stack.contract.MonitoredLimitedStack;
import clean.project.ds.stack.factory.StackFactoryBuilder;

public class InfixToPostfixConverter {
    private static StackFactoryBuilder<Character> characterStackFactoryBuilder = new StackFactoryBuilder<Character>();

    private void convertInfixToPostfix(final String input) throws Exception {
        MonitoredLimitedStack<Character> characterMonitoredLimitedStack = characterStackFactoryBuilder.buildMonitoredLimitedStackFactory().getStack(100);
        System.out.println("Input: " + input);
        final StringBuffer postfixStringBuffer = new StringBuffer();
        char [] inputAsCharArray = input.toCharArray();
        for (char currentChar : inputAsCharArray) {
            if (!OperatorPrecedence.isOperator(currentChar)) {
                postfixStringBuffer.append(currentChar);
            } else {
                while (!characterMonitoredLimitedStack.isEmpty()
                && OperatorPrecedence.isLeftOperatorOfHigherPrecedence(characterMonitoredLimitedStack.peek(), currentChar)) {
                    char topSymbol = characterMonitoredLimitedStack.pop();
                    postfixStringBuffer.append(topSymbol);
                }
                characterMonitoredLimitedStack.push(currentChar);
            }
        }
        while (!characterMonitoredLimitedStack.isEmpty()) {
            char topSymbol = characterMonitoredLimitedStack.pop();
            postfixStringBuffer.append(topSymbol);
        }
        System.out.println("Output: " + postfixStringBuffer.toString());
    }

    public static void main(String[] args) {
        final InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
        try {
            infixToPostfixConverter.convertInfixToPostfix("A*B+C*D");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

enum OperatorPrecedence {
    DIVISION(4, '/'), MULTIPLICATION(3, '*'), ADDITION(2, '+'), SUBTRACTION(1, '-');
    private int precedence;
    private char symbol;

    private static final OperatorPrecedence [] VALUES = values();

    OperatorPrecedence(final int precedence, final char symbol) {
        this.precedence = precedence;
        this.symbol = symbol;
    }

    public static boolean isOperator(final char symbol) {
        for (OperatorPrecedence operatorPrecedence : VALUES) {
            if (operatorPrecedence.symbol == symbol) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeftOperatorOfHigherPrecedence(final char left, final char right) throws Exception{
        OperatorPrecedence leftOperator = findEnumForOperator(left);
        OperatorPrecedence rightOperator = findEnumForOperator(right);
        boolean isLeftHigher = false;
        if (leftOperator.precedence > rightOperator.precedence) {
            isLeftHigher = true;
        }
        return isLeftHigher;
    }

    private static OperatorPrecedence findEnumForOperator(final char operator) throws Exception {
        for (OperatorPrecedence operatorPrecedence : VALUES) {
            if (operatorPrecedence.symbol == operator) {
                return operatorPrecedence;
            }
        }
        throw new Exception("Operator enum not found for operator " + operator);
    }

}
