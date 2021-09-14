package practice.String;

public class ReverseStringWithoutExtraSpace {
    public static void main(String[] args) {
        String st = "this is vinay kumar";
        String[] stAr = st.split("\\s");
        reverse(stAr);
    }

    private static void reverse(String[] sar) {
        int l = sar.length;
        if (l % 2 == 0) {

            int j = l / 2;
            while (j <= l - 1) {
                String temp = sar[l - j - 1];
                sar[l - j - 1] = sar[j];
                sar[j] = temp;
                j++;
            }

        } else {
            int j = (l / 2) + 1;

            while (j <= l - 1) {
                String temp = sar[l - j - 1];
                sar[l - j - 1] = sar[j];
                sar[j] = temp;
                j++;
            }
        }

        System.out.println(String.join(" ",sar));

    }
}
