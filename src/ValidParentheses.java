import java.util.Stack;

/**
 * Created by crainax on 2016/10/21.
 */
public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid("(())"));

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
                    if (stack.isEmpty()){
                        stack.push(aChar);
                        continue;
                    }

                    peek = stack.peek();
                    if (peek != '(' && peek != '[' && peek != '{') {
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
                        stack.push(aChar);
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;

                    peek = stack.peek();
                    if (peek == '[') {
                        stack.push(aChar);
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;

                    peek = stack.peek();
                    if (peek == '{') {
                        stack.push(aChar);
                    } else {
                        return false;
                    }
                    break;
            }
        }

        Character peek = stack.peek();
        System.out.println(stack);
        return peek == ')' || peek == ']' || peek == '}';
    }

}
