package practice.queue;

public class PetrolPumTour {

    static class PetrolPump
    {
        int petrol;
        int dist;
        PetrolPump(int petrol,int dist)
        {
            this.dist = dist;
            this.petrol = petrol;
        }
    }

    private static int printTour(PetrolPump[] pumps , int n)
    {
        int start =0,end =1;
        int petrol  = pumps[start] .petrol - pumps[start].dist;
        while(start != end || petrol < 0)
        {
            while(petrol<0  &&  start != end)
            {
                petrol -= pumps[start].petrol - pumps[start].dist;
                start = (start+1)%n;
                if(start == 0)
                    return -1;
            }

            petrol += pumps[end].petrol - pumps[end].dist;
            end = (end+1)%n;

        }
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

        int start = printTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }
}
