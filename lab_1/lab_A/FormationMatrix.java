import java.util.Scanner;

public class FormationMatrix {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    System.out.println("Enter matrix i, then j:");
    int[][] matrix = makeArray(scn.nextInt(), scn.nextInt());
    for (int[] line : matrix) {
      for (int num : line) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
    scn.close();
  }

  public static int[][] makeArray(int i, int j) {
    int[][] arr = new int[i][j];
    for (int a = 0; a < i; a++) {
      arr[a][0] = 1;
      for (int b = 1; b < j; b++) {
        arr[a][b] = 0;
      }
    }
    return arr;
  }
}