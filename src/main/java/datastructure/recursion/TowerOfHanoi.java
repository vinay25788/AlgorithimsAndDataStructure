package datastructure.recursion;

class Count
{
    int count;
}
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n =3;


        Count count = new Count();
     solve(1,2,3,n,count);
        System.out.println(count.count);
    }
    public static void solve(int s,int d,int h,int n,Count count)
    {
        count.count++;

        if(n==1)
        {
            System.out.println(" moving disk "+n+" from source "+s+" poll to destination "+d+" poll");
return;

        }
       solve(s,h,d,n-1,count);
        System.out.println(" moving disk "+n+" from source "+s+" poll to destination "+d+" poll");

       solve(h,d,s,n-1,count);

    }
}
