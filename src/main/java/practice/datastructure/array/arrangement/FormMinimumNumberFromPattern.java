package practice.datastructure.array.arrangement;

import java.util.Stack;

public class FormMinimumNumberFromPattern {
    public static void main(String[] args) {
        String s = "DDIDDIID";
        generateNumber(s);
    }
    public static void generateNumber(String st)
    {
        Stack<Integer> stack = new Stack<>();
        int n = st.length();

        for(int i=0;i<= n;i++)
        {
            stack.push(i+1);

                if (i == n || st.charAt(i) == 'I') {
                    while(!stack.isEmpty())
                        System.out.print(stack.pop());
                }

        }
    }
}
