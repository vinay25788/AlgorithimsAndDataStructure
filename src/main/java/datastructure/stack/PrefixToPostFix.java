package datastructure.stack;

import java.util.Stack;

public class PrefixToPostFix {

    public Boolean isOperator(char x)
    {
        switch(x)
        {
            case    '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;

        }
        return false;
    }

    public String convert(String exp)
    {
        String result = new String("");
        Stack<String> st = new Stack<>();
        int n = exp.length();
        for(int i=n-1;i>=0;i--) {
            if (isOperator(exp.charAt(i)))
            {
                String op1 = ""+st.pop();
                String op2 = ""+st.pop();
                String temp = op1+op2+exp.charAt(i);
                st.push(temp);

            }
            else
            {
                st.push(exp.charAt(i)+"");
            }
        }
        return st.peek();

    }

    public static void main(String[] args) {
        PrefixToPostFix obj = new PrefixToPostFix();
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : "
                + (obj.convert(pre_exp)));
    }
}
