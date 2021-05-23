package datastructure.stack;

import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        String st = "Hi This is Vinay";
        reverse(st);
    }

    public static void reverse(String st) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < st.length(); i++)
            stack.push(st.charAt(i));

        String temp = "";
        String rev = "";

        while (!stack.isEmpty()) {

            if (Character.isLetter(stack.peek())) {
                temp =temp+ stack.pop();
            } else {
                rev = " " + temp + rev;
                temp ="";
                stack.pop();
            }
        }
        if (temp != "") {
            rev = " " + temp + rev;
        }

        System.out.println(rev);

    }

}
