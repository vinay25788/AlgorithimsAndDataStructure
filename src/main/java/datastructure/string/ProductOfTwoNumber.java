package datastructure.string;

public class ProductOfTwoNumber {
    public static void main(String[] args) {
        String s1 = "1235421415454545454545454544";
        String s2 = "1714546546546545454544548544544545";
        if ((s1.charAt(0) == '-' || s2.charAt(0) == '-') && (s1.charAt(0) != '-' || s2.charAt(0) != '-'))
            System.out.println('-');
        if (s1.charAt(0) == '-')
            s1 = s1.substring(1);
        if (s2.charAt(0) == '-')
            s2 = s2.substring(1);
        System.out.println(calculate(s1, s2));
    }

    public static String calculate(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == 0 || n2 == 0)
            return "0";
        int result[] = new int[n1 + n2];
        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            int num1 = s1.charAt(i) - '0';
            i_n2 = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                int num2 = s2.charAt(j) - '0';
                int sum = num1 * num2 + result[i_n1 + i_n2] + carry;
                carry = sum / 10;
                result[i_n1 + i_n2] = sum % 10;
                i_n2++;
            }
            if (carry > 0)
                result[i_n1 + i_n2] += carry;
            i_n1++;

        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";
        String s = "";
        while (i >= 0)
            s += result[i--];

        return s;
    }
}
