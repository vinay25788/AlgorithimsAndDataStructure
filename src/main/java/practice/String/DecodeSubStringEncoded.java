package practice.String;


import java.util.Stack;

public class DecodeSubStringEncoded {
    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        decode(str);
    }

    public static void decode(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();
        int n = str.length();
        String temp ="", result ="";

        for (int i = 0; i < n; i++) {
            int count = 0;
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count*10+ str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerStack.push(count);
            } else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    stringStack.push(str.charAt(i));
                } else {
                    stringStack.push(str.charAt(i));
                    integerStack.push(1);
                }
            } else if (str.charAt(i) == ']') {

                count = 0;

                temp ="";
                if (!integerStack.isEmpty())
                    count = integerStack.pop();

                while (!stringStack.isEmpty() && stringStack.peek() != '[')
                {
                    temp = stringStack.peek()+temp;
                    stringStack.pop();
                }

                if(!stringStack.isEmpty() && stringStack.peek() == '[')
                stringStack.pop();

                for (int j = 0; j < count; j++)
                    result += temp;

                for (int k = 0; k < result.length(); k++)
                    stringStack.push(result.charAt(k));
                result = "";

            } else
                stringStack.push(str.charAt(i));

        }
        while (!stringStack.isEmpty())
        {
            result = stringStack.pop()+result;
        }
        System.out.println(result);
    }
}
