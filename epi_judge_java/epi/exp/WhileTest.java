package epi.exp;

public class WhileTest {
    public static void main(String[] args) {
        int x = 0, y = 0;

        System.out.println();

        while (x < 5 || y < 8) {
            System.out.println(x + "," + y);
            x++;
            y++;
        }

        int i = 0;
        while (i < 5) {;
            i++;
            System.out.println(i);
        }

        System.out.println(i);
    }
}
