package effectivejava3;


public class staticFactory {
    public static void main(String[] args) {
        Boolean bl = Boolean.valueOf("false");
        System.out.println(bl);
        Object object = new Object();
    }
}
