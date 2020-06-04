package clean.project.ds.stack.application;

import clean.project.ds.stack.contract.LimitedStack;
import clean.project.ds.stack.factory.StackFactoryBuilder;

public class ParenthesesSyntaxChecker {
    private static StackFactoryBuilder<Character> characterStackFactoryBuilder = new StackFactoryBuilder<Character>();

    private boolean checkParenthesisSyntax(final String input) throws Exception {
        final LimitedStack<Character> characterLimitedStack = characterStackFactoryBuilder.buildLimitedStackFactory().getStack(100);
        char [] inputAsCharArray = input.toCharArray();
        boolean isValid = true;
        for (char currentChar : inputAsCharArray) {
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                characterLimitedStack.push(currentChar);
            }

            if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (characterLimitedStack.isEmpty()) {
                    isValid = false;
                } else {
                    Character stackTop = characterLimitedStack.pop();
                    if (getMatchingOpener(currentChar) != stackTop) {
                        isValid = false;
                    }
                }
            }
        }
        if (!characterLimitedStack.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }

    private char getMatchingOpener(final char closer) {
        if (closer == ')') {
            return '(';
        } else if (closer == ']') {
            return '[';
        } else if (closer == '}') {
            return '{';
        }
        return ' ';
    }

    public static void main(String[] args) {
        final String firstExample = "[(A + B])";
        final String secondExample = "(A + B) - {C + D} - [F + G]";
        final String thirdExample = "((H) * {([J + K])})";
        final String [] examples = {firstExample, secondExample, thirdExample};
        final ParenthesesSyntaxChecker parenthesesSyntaxChecker = new ParenthesesSyntaxChecker();
        for (String example: examples) {
            try {
                System.out.println(String.format("The syntax for example \"%s\" is valid? : %s", example, parenthesesSyntaxChecker.checkParenthesisSyntax(example)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
