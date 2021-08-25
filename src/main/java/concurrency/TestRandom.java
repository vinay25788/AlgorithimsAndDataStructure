package concurrency;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {

        Random random = new Random();
        for(int i=0;i<10;i++)
            System.out.println((int)random.nextInt(2));
        String OAUTH_URL = "test ";
        String oauthUrl ="";
        for(int i=0;i<5;i++) {
            if (random.nextBoolean())
                oauthUrl = OAUTH_URL;
            else
                oauthUrl = OAUTH_URL + 'a';
            System.out.println(oauthUrl);
        }

    }
}
