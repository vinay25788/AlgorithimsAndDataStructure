package org.example.dsa;

public class HitCounter {

    int[] timestamps;
    int[] hitCounter;

    HitCounter()
    {
        timestamps = new int[300];
        hitCounter = new int[300];

    }

    public void hit(int timestamp)
    {
        int index = timestamp%300;
        if(timestamps[index] != timestamp)
        {
            timestamps[index] = timestamp;
            hitCounter[index] = 1;
        }
        else
        {
            hitCounter[index]++;
        }
    }

    public int getCount(int timestamp)
    {
        int total =0;

        for(int i=0;i<300;i++)
        {
            if(timestamp-timestamps[i]<300)
            {
                total+=hitCounter[i];
            }
        }
        return total;
    }
}
