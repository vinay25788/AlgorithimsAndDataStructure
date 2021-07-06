package immutable;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class Test implements Cloneable
{
    public Test clone() throws CloneNotSupportedException {
        return (Test) super.clone();
    }

}
final public class ImmutableDemo  extends Test{

   private final  String name;
   private final int id;
   private final Map<String,String> ma;
    ImmutableDemo(String name,int id, Map<String,String> map)
    {
        this.name = name;
        this.id = id;
        Map<String, String> m = new HashMap<>();
        for(Map.Entry<String,String> entry:map.entrySet())
        {
            m.put(entry.getKey(),entry.getValue());
        }
        this.ma = m;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Map<String,String >   getMa()
    {
        Map<String, String> m = new HashMap<>();
        for(Map.Entry<String,String> entry:this.ma.entrySet())
        {
            m.put(entry.getKey(),entry.getValue());
        }
        return m;
    }

    private ImmutableDemo() throws Exception {
        throw new Exception();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String,String> map = new HashMap<>();
        map.put("kumar","1");
        ImmutableDemo obj = new ImmutableDemo("vinay",4,map);
        System.out.println(obj.getName()+" "+obj.getId());

        System.out.println(obj.getMa().get("kumar"));

        ImmutableDemo obj2 = (ImmutableDemo) obj.clone();


    }


    public void differentWayToCreateObject() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {

        Test test = new Test();
        Test test2 = Test.class.newInstance();;
        Constructor<Test> constructorTest = Test.class.getConstructor();
        Test test3 = constructorTest.newInstance();

        Test test4= test3.clone();

        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("file.ser"));
        ois.writeObject(test4);
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("file.ser"));
        Test test5 = (Test) is.readObject();
    }
}
