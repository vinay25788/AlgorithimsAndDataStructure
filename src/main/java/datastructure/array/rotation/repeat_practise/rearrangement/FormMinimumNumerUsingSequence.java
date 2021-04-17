package datastructure.array.rotation.repeat_practise.rearrangement;

import java.util.Stack;

public class FormMinimumNumerUsingSequence {
    public static void main(String[] args) {
        PrintMinNumberForPattern("IDID");
    }

    public static void PrintMinNumberForPattern(String seq) {
        String result = " ";
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= seq.length(); i++) {
            st.push(i + 1);

            if (i == seq.length() || seq.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    result += String.valueOf(st.peek());
                    result += " ";
                    st.pop();
                }
            }
        }
        System.out.println(result);

    }
}
