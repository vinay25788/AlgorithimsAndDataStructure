package practice.String;

public class StringMatchingRecursion {
    public static void main(String[] args) {
        test("g*ks", "geeks");
        test("a*b", "akkk");
    }
    public static void test(String first,String second)
    {
        boolean matched  = match(first,second);
        if(matched)
            System.out.println(" matched");
        else
            System.out.println(" not matched ");
    }
    private static boolean match(String first, String second)
    {
        // we are done
        /*if(first.length() ==0 && second.length() ==0)
            return true;

        if(first.length() >1 && first.charAt(0) == '*' && second.length() ==0)
            return false;

        // If the first string contains '?',
        // or current characters of both strings match
        if ((first.length() > 1 && first.charAt(0) == '?') ||
                (first.length() != 0 && second.length() != 0 &&
                        first.charAt(0) == second.charAt(0)))
            return match(first.substring(1),
                    second.substring(1));

        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (first.length() > 0 && first.charAt(0) == '*')
            return match(first.substring(1), second) ||
                    match(first, second.substring(1));
        return false;*/

        if(first.length() ==0 && second.length() ==0)
            return true;
       if(first.length() >1 && first.charAt(0) == '*' && second.length() ==0)
          return false;

        if((first.length() >1 && first.charAt(0) == '?') || (first.length() !=0 && second.length() !=0 && first.charAt(0) == second.charAt(0)))
            return match(first.substring(1),second.substring(1));

        if(first.length()>0 && first.charAt(0) == '*')
            return match(first.substring(1),second) || match(first,second.substring(1));
        return false;

    }
}
