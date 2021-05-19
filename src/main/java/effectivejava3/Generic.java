package effectivejava3;

import java.awt.event.ItemEvent;
import java.util.*;

public class Generic {

    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        unsafeAdd(list,String.valueOf(12));
        String st = (String) list.get(0);
        Set s1 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add("kumar");s1.add("hi");

        Set s2 = new HashSet();
        s2.add(1);
        s2.add(3);
        s2.add(2);
        s2.add("Hi");s2.add("hsarma");
        System.out.println(add(s1,s2));
    }
    public static void unsafeAdd(List<Object> list,Object o)
    {
        list.add(o);

    }

    public static  int add(Set<?> s1, Set<?> s2)
    {
        Iterator it = s1.iterator();
        while(it.hasNext())
        {
            String st = (String) it.next();
            System.out.println(st);
        }
        System.out.println(s1);
        s1.add(null);
        //s1.add(1);
        int result =0;
        for(Object ob: s1)
            if(s2.contains(ob))
                result++;

            return result;
    }
}
