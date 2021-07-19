package searialize;

import java.io.*;

class Student implements Serializable,ObjectInputValidation
{
    String name;
    int id;

    Student(String name,int id)
    {
        this.name = name;
        this.id = id;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println(" serialization started writeObject");
        out.defaultWriteObject();
    }

    private Object writeReplace()
    {
        System.out.println(" replacing writeReplace ");
       return new Student( " garg ",19);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println(" deserialization started readObject ");
        in.registerValidation(this,0);
        in.defaultReadObject();

    }

  /*  private Object readResolve()
    {
        System.out.println(" read resolve ");
        return new Student("sharma",13);
    }*/

    @Override
    public String toString()
    {
      return  String.format(" employee name %s, id ",this.name,this.id);
    }

    @Override
    public void validateObject() {
        System.out.println("Validating age.");

        if (this.id < 18 || this.id > 70)
        {
            throw new IllegalArgumentException("Not a valid age to create an employee");
        }
    }

}

public class SerializeDemo {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("kumar",19);
            FileOutputStream file = new FileOutputStream("file.ser");
            try {
                ObjectOutputStream ois = new ObjectOutputStream(file);
                ois.writeObject(s1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("file.ser");
            try {
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                try {
                    Student s2 = (Student) ois.readObject();
                    System.out.println(s2.name+" "+s2.id);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
