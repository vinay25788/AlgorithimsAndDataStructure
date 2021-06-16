package datastructure.string;

public class SumTwoLargetNumber {
    public static void main(String[] args) {
        String st = "12";
        String st2 = "198111";
        System.out.println(findSum(st, st2));
    }

    public static String findSum(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
        }

        int n1 = s1.length();
        int n2 = s2.length();

        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        String res = "";
        int carry = 0;
        for (int i = 0; i < n1; i++) {
            int sum = ((int) (s1.charAt(i) - '0') + (int)(s2.charAt(i) - '0') + carry);
            res +=   (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        for (int i = n1; i < n2; i++) {
            int sum = ((int)(s2.charAt(i) - '0') + carry);
            res += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0)
            res += (char)(carry + '0');

        res = new StringBuilder(res).reverse().toString();
        return res;
    }
}
