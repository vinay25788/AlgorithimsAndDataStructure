package datastructure.stack;

import java.util.Stack;

public class DecodeStringRecursively {
    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        decodeAndEncode(str);
    }

    public static void decodeAndEncode(String str) {
        Stack<Character> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        int n = str.length();
        String temp = "";
        String result = "";

        for (int i = 0; i < n; i++) {
            int count = 0;

            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerStack.push(count);
            } else if (str.charAt(i) == '[') {

                if (Character.isDigit(str.charAt(i - 1)))
                    stringStack.push(str.charAt(i));
                else {
                    stringStack.push(str.charAt(i));
                    integerStack.push(1);
                }
            } else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;

                if (!integerStack.isEmpty())
                    count = integerStack.pop();

                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.peek() + temp;
                    stringStack.pop();
                }

                if (!stringStack.isEmpty() && stringStack.peek() == '[')
                    stringStack.pop();

                for (int j = 0; j < count; j++) {
                    result = result + temp;
                }

                for (i = 0; i < result.length(); i++)
                    stringStack.push(result.charAt(i));
                result = "";
            } else
                stringStack.push(str.charAt(i));
        }

        while (!stringStack.isEmpty()) {
            result =  stringStack.pop()+ result;
        }
        System.out.println(" Decoded String " + result);
    }
}
