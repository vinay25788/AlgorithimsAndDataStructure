package datastructure.string;

public class AddTwoBinary {
    public static void main(String[] args) {
        String a = "1101", b = "100";

        System.out.print(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        String res = "";
        int s = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {
            s += (i >= 0) ? a.charAt(i) - '0' : 0;
            s += (j >= 0) ? b.charAt(j) - '0' : 0;
            res = (char) ( s % 2 + '0') + res;
            s = s / 2;
            i--;
            j--;
        }
        return res;
    }
}
