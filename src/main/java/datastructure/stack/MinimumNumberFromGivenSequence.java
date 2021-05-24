package datastructure.stack;

import java.util.Stack;

public class MinimumNumberFromGivenSequence {
    public static void main(String[] args) {
        String seq = "IDID";
        formNumber(seq);
    }
    public static void formNumber(String seq)
    {
        int n = seq.length();
        String result = "";
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++)
        {
            st.push(i+1);
            if(i== seq.length() || seq.charAt(i) == 'I')
            while(!st.isEmpty())
                result+=" "+String.valueOf(st.pop());
        }
        System.out.println(result);
    }
}
