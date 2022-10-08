package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import javax.sound.midi.Soundbank;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class KthLargestInArray {
  // The numbering starts from one, i.e., if A = [3,1,-1,2] then
  // findKthLargest(1, A) returns 3, findKthLargest(2, A) returns 2,
  // findKthLargest(3, A) returns 1, and findKthLargest(4, A) returns -1.
  @EpiTest(testDataFile = "kth_largest_in_array.tsv")
  public static int findKthLargest(int k, List<Integer> A) {
    // TODO - you fill in here.

//    A.sort((o1, o2) -> Integer.compare(o2, o1));
//    return A.get(k - 1);


   // System.out.println(A);
   // quickSort(A);
   // System.out.println(A);
   // return A.get(k - 1);

    return quickSelect(A, k);
  }

  private static int quickSelect(List<Integer> A, int k) {
    return quickSelect(A, k, 0, A.size() - 1);
  }

  private static int quickSelect1(List<Integer> A, int k, int l, int r) {
    while (l <= r) {
      int p = partition(A, l, r);

      if (p == k - 1) {
        return A.get(p);
      }

      if (p < k - 1) {
        l = p + 1;
      } else {
        r = p - 1;
      }
    }

    return -1;
  }

  private static int quickSelect(List<Integer> A, int k, int l, int r) {
    int p = partition(A, l, r);
    if (p == k - 1) return A.get(p);

    if (p < k - 1) {
      return quickSelect(A, k, p + 1, r);
    } else {
      return quickSelect(A, k, l, p - 1);
    }
  }

  private static void quickSort(List<Integer> A) {
    quickSort(A, 0, A.size() - 1);
  }

  private static void quickSort(List<Integer> A, int l, int r) {
    if (l >= r || l < 0) return;

    int p = partition(A, l, r);

    quickSort(A, l, p - 1);
    quickSort(A, p + 1, r);
  }

  private static int partition(List<Integer> A, int l, int r) {
    int p = A.get(r);

    int c = l;

    for (int i = l; i <= r - 1; i++) {
      if (A.get(i) >= p) {
        Collections.swap(A, c, i);
        c++;
      }
    }

    Collections.swap(A, c, r);
    return c;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestInArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
