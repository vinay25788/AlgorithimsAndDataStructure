package practice.stack;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String st = "a+b*(c^d-e)^(f+g*h)-i";
        convert(st);
    }
    private static void convert(String st)
    {
        Stack<Character> stack = new Stack<>();
        String res ="";
        int n = st.length();
        for(int i=0;i<n;i++)
        {
            char ch = st.charAt(i);
            if(Character.isLetterOrDigit(ch))
                res +=ch;
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                    res+= stack.pop();
                stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && prec(stack.peek()) >=prec(ch))
                    res +=stack.pop();
                stack.push(ch);
            }
        }
        System.out.println(res);
    }

    private static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
            return -1;
    }
}
