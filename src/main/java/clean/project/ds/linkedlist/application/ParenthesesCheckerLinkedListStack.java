package clean.project.ds.linkedlist.application;

import clean.project.ds.stack.contract.UnlimitedStack;
import clean.project.ds.stack.factory.StackFactoryBuilder;

public class ParenthesesCheckerLinkedListStack {
    private static StackFactoryBuilder<Character> characterStackFactoryBuilder = new StackFactoryBuilder<Character>();

    private boolean checkParenthesisSyntax(final String input) throws Exception {
        final UnlimitedStack<Character> characterUnlimitedStack = characterStackFactoryBuilder.buildUnlimitedStackLinkedListFactory().getStack(-1);
        char [] inputAsCharArray = input.toCharArray();
        boolean isValid = true;
        for (char currentChar : inputAsCharArray) {
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                characterUnlimitedStack.push(currentChar);
            }

            if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (characterUnlimitedStack.isEmpty()) {
                    isValid = false;
                } else {
                    Character stackTop = characterUnlimitedStack.pop();
                    if (getMatchingOpener(currentChar) != stackTop) {
                        isValid = false;
                    }
                }
            }
        }
        if (!characterUnlimitedStack.isEmpty()) {
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
        final ParenthesesCheckerLinkedListStack parenthesesSyntaxChecker = new ParenthesesCheckerLinkedListStack();
        for (String example: examples) {
            try {
                System.out.println(String.format("The syntax for example \"%s\" is valid? : %s", example, parenthesesSyntaxChecker.checkParenthesisSyntax(example)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
