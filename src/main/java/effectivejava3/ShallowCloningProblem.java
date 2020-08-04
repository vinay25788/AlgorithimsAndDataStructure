package effectivejava3;

import java.awt.*;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Hashtable;

public class ShallowCloningProblem  implements Cloneable{

    Hashtable hashtable;

    ShallowCloningProblem(Hashtable hashtable)
    {
        this.hashtable = hashtable;
    }

    @Override
    public ShallowCloningProblem clone() throws CloneNotSupportedException {
        ShallowCloningProblem result = (ShallowCloningProblem) super.clone();
        result.hashtable = (Hashtable) this.hashtable.clone();
        System.out.println("calender -->"+Calendar.getInstance());
        
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Hashtable hashtable = new Hashtable();
        hashtable.put(1,"vinay");
        hashtable.put(2,"kumar");

        ShallowCloningProblem obj = new ShallowCloningProblem(hashtable);
        System.out.println(obj.hashtable);
        ShallowCloningProblem clo = obj.clone();
        clo.hashtable.put(1,"Garg");
        System.out.println(clo.hashtable);


    }
}
