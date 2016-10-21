import java.util.Stack;

/**
 * Created by crainax on 2016/10/21.
 */
public class ValidParentheses_2 {

    public static void main(String[] args) {

        ValidParentheses_2 validParentheses = new ValidParentheses_2();

        System.out.println(validParentheses.isValid("(((())))"));

    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            Character peek;
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    if (stack.isEmpty()) {
                        stack.push(aChar);
                        break;
                    }

                    peek = stack.peek();
                    if (peek == '(' || peek == '[' || peek == '{') {
                        stack.push(aChar);
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;

                    peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;

                    peek = stack.peek();
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;

                    peek = stack.peek();
                    if (peek == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return stack.size() == 0;
    }

}
