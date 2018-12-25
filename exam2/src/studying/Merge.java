package studying;

import java.util.Arrays;

public class Merge {

  public static void main(String[] args) {
    int A[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    int B[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    int Merge[] = new int[20];
    int temp = 0;

    // 배열 A,B를 배열 Merge에 추가
    System.arraycopy(A, 0, Merge, 0, A.length);
    System.arraycopy(B, 0, Merge, A.length, B.length);

    // 합쳐진 배열을 버블정렬
    for (int i = 0; i < Merge.length - 1; i++) {
      for (int j = 0; j < Merge.length - i - 1; j++) {
        if (Merge[j] > Merge[j + 1]) {
          temp = Merge[j];
          Merge[j] = Merge[j + 1];
          Merge[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(Merge));
  }

}
