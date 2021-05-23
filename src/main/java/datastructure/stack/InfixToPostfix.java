package datastructure.stack;

import java.util.Stack;

public class InfixToPostfix {

    public int precedence(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;

        }
    }

    public String convert(String exp) {
        String result = new String("");
        Stack<Character> st = new Stack<>();
        for (int i = 0; i <exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            } else if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    result += st.pop();
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(ch) <= precedence(st.peek()))
                    result += st.pop();
                st.push(ch);
            }

        }
        while (!st.isEmpty()) {
            if (st.peek() == '(')
                return "Invalid experession";
            result += st.pop();
        }

        return result;

    }

    public static void main(String[] args) {
        InfixToPostfix obj = new InfixToPostfix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(obj.convert(exp));
    }
}
