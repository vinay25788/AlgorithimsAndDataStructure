package datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthese {

    public static Boolean areBracketsBalanced(String exp)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch == '{' || ch == '[' || ch=='(')
            {
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty())
                return false;

            char check;
            switch (ch)
            {
                case ')':
                            check = stack.pop();
                            if(check == '{'|| check =='[')
                                return false;
                            break;
                case '}':
                            check = stack.pop();
                            if(check == '[' || check =='(')
                                return  false;
                            break;
                case ']':
                            check = stack.pop();
                            if(check =='{'|| ch == '(')
                                return false;
                            break;

            }
        }



        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String expr = "([{}])";

        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
