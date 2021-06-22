package datastructure.string;

public class CheckIfRotatedStringEqualToGivenString {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "eksge";

        System.out.println(isRotated(str1,str2));
    }
    public static boolean isRotated(String st1,String st2)
    {
        int l1 = st1.length();
        int l2 = st2.length();
        if(l1 != l2)
        {
            System.out.println(" not possible ");
            return false;
        }

        String antiClockWise ="";
        String clockWise ="";
        antiClockWise = antiClockWise+ st1.substring(l1-2,l1)+st1.substring(0,l1-2);
        clockWise = clockWise+ st1.substring(2,l1)+ st1.substring(0,2);
        if(antiClockWise.equalsIgnoreCase(st2))
        {
            System.out.println(" anticlockwise "+antiClockWise);
            return true;
        }
        if(clockWise.equalsIgnoreCase(st2))
        {
            System.out.println("clockwise "+clockWise);
            return true;
        }
        return false;
    }
}
