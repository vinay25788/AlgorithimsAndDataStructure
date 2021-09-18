package practice.stack;

import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        String st="{()[]}";
        System.out.println(check(st));
    }
    private static boolean check(String st)
    {
        Stack<Character> stack = new Stack<>();
        int n = st.length();

        for(int i=0;i<n;i++)
        {
            char ch = st.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty())
                return false;
            char popped = stack.pop();
            switch (ch)
            {
                case ')' : if(popped != '(')
                {
                    return false;
                }
                break;
                case ']' : if(popped != '[')
                            return false;
                break;
                case '}' : if(popped  != '{')
                       return false;
                break;

            }
        }
        return true;
    }
}
