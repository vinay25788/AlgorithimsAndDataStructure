package datastructure.array.pracitise.array.arrangement;

import java.util.Stack;

public class MinimumNumberFromGivenPattern {
    public static void main(String[] args) {
        String st = "IIDDD";
        formNumber(st);
    }

    public static void formNumber(String st) {
        char[] ch = st.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= ch.length; i++) {
            stack.push(i+1);
            while ( !stack.isEmpty() && (i == ch.length || ch[i] == 'I')) {


                if (!stack.isEmpty())
                    System.out.print(stack.pop());


            }
        }
    }
}
