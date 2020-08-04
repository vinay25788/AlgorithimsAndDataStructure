package effectivejava3;


public class ClonningExample implements Cloneable{

     String[] name = new String[2];

   public ClonningExample(String[] st)
    {
        this.name = st;
    }

    public String toString()
    {
        return  name[0]+" "+name[1];
    }

    @Override
    public ClonningExample clone() throws CloneNotSupportedException {

       ClonningExample result = (ClonningExample) super.clone();

       result.name = this.name.clone();

        return result;

    }
    public static void main(String[] args) throws CloneNotSupportedException {

        String [] st = {"vinay","kumar"};
        ClonningExample obj = new ClonningExample(st);

        ClonningExample clo = obj.clone();

        clo.name[0] = "sharma";
        System.out.println(clo.name[0]);
        System.out.println(obj.name[0]);
    }
}
