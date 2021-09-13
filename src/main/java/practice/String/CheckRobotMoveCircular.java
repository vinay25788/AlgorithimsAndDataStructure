package practice.String;

public class CheckRobotMoveCircular {
    public static void main(String[] args) {
        String path = "GLGLGLG";
        checkForCircular(path);
    }

    public static void checkForCircular(String path) {
        char[] paths = path.toCharArray();
        int dir = 0;
        int x = 0, y = 0;
        int n = paths.length;
        for (int i = 0; i < n; i++) {
            if (paths[i] == 'R')
                dir = (dir + 1) % 4;
            else if (paths[i] == 'L')
                dir = ( dir - 1) % 4;
            else {
                if (dir == 0)
                    y++;
                else if (dir == 1)
                    x++;
                else if (dir == 2)
                    y--;
                else if (dir == 3)
                    x--;

            }
        }
        System.out.println("x " + x + " y " + y);

    }
}
