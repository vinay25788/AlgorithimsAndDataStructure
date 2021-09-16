package java8;

public class TryDemo {
    public static void main(String[] args) {
        try
        {
            System.out.println("hello");
           System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("hello exception occur "+e.getMessage());
        }
        finally {
            System.out.println("finnally ");
        }
    }
}
