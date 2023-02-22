package Applications.Parantheses;

public class Parentheses {
    private static final char[] openBrackets = {'(', '[', '{','<'};
    private static final char[] closeBrackets = {')', ']', '}','>'};
    
    private static boolean isOpenBracket(char c) {
        for (char bracket : openBrackets) {
            if (bracket == c) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isCloseBracket(char c) {
        for (char bracket : closeBrackets) {
            if (bracket == c) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean bracketsMatch(char open, char close) {
        int openIndex = findIndex(openBrackets, open);
        int closeIndex = findIndex(closeBrackets, close);
        return openIndex == closeIndex;
    }
    
    private static int findIndex(char[] arr, char c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean checkFullArray(String s) {
        CharStack stack = new CharStack(5);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (isCloseBracket(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (!bracketsMatch(last, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
