package practice.String;

public class RotatedString {
    public static void main(String[] args) {
        String st1 = "amazon";
        String st2 = "azonam";
        isRotate(st1, st2);
    }

    public static void isRotate(String st1, String st2) {
        if (st1.length() != st2.length()) {
            System.out.println(" Not rotated");
            return;
        }
        if (st2.length() < 2) {
            System.out.println(st1.equals(st2));
            return;
        }
        String anticlockwise = "";
        String clockwise = "";

        int len = st2.length();
        anticlockwise = anticlockwise + st2.substring(len - 2, len) + st2.substring(0, len - 2);
        clockwise = clockwise + st2.substring(2) + st2.substring(0, 2);
       if (anticlockwise.equalsIgnoreCase(st1) || clockwise.equalsIgnoreCase(st1))
            System.out.println(" rotated ");
        else
            System.out.println(" not rotated ");
    }
}
