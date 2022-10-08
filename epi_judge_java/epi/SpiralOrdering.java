package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SpiralOrdering {
  @EpiTest(testDataFile = "spiral_ordering.tsv")

  public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    if (squareMatrix.size() == 0) {
      return new ArrayList<>();
    }




    List<Integer> r = new ArrayList<>();

    int x = 0, y = 0;

    int m = squareMatrix.size();
    int n = squareMatrix.get(0).size();

    int d = 0;
    int c = 0;

    int[][] shift = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int dir = 0;
    while (c != m * n) {
      r.add(squareMatrix.get(y).get(x));

      if ((x == n - 1 - d && y == d)
              || (x == n - 1 - d && y == m - 1 - d)
              || (x == d && y == m - 1 - d)
              || (x == d && y == d + 1)) {

        dir =  (dir + 1) % 4;
      }

      if (x == d && y == d + 1) {
        d++;
      }

      x = x + shift[dir][0];
      y = y + shift[dir][1];

      c++;

//      System.out.println(c + " " + r);
    }

    return r;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
