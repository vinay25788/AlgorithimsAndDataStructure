package datastructure.queue;

public class CurrencyProvide {
    public static void main(String[] args) {
        int[] currency = {5, 5, 5, 10, 20};

            checkForCurrency(currency);
    }

    public static void checkForCurrency(int[] currency)
    {
        int fiveCount =0;
        int tenCount =0;
        int n = currency.length;
        for(int i=0;i<n;i++)
        {
            if(currency[i] == 5)
                fiveCount++;
            else if (currency [i] == 10)
            {
                if(fiveCount>0){
                    fiveCount--;
                tenCount++;}
                else
                {
                    System.out.print(" 0 ");
                    return;
                }
            }
            else
            {
                if(fiveCount>0 && tenCount>0)
                {
                    fiveCount--;
                    tenCount--;
                }
                else if ( fiveCount>=3)
                    fiveCount-=3;
                else
                {
                    System.out.print(" 0 ");
                    return;
                }
            }
        }
        System.out.println(" He can provide change to all;");
    }
}
