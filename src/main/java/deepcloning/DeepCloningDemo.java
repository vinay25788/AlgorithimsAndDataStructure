package deepcloning;

class Address implements Cloneable {
    private String city;

    Address(String city) {
        this.city = city;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Student implements Cloneable {
    String name;
    Address address;


    public Student(String name, Address address) {
        this.name = name;
        Address add = new Address(address.getCity());
        this.address = add;
    }

    public Address getAddress() {

        Address address = new Address(this.address.getCity());
        return address;

    }

    public Object clone() throws CloneNotSupportedException {
        Student st = (Student) super.clone();
        st.setAddress((Address) this.address.clone());
        return st;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        Address address1 = new Address(address.getCity());
        this.address = address1;
    }
}

public class DeepCloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address add = new Address(" shimla");
        Student s1 = new Student("Vinay", add);
        Student s2 = (Student) s1.clone();
        System.out.println(s2.name + " " + s2.address.getCity());

        add.setCity(" una");
        s1.address.setCity("una");
        System.out.println(s1.name + " " + s1.address.getCity());

        System.out.println(s2.name + " " + s2.getAddress().getCity());


    }
}
