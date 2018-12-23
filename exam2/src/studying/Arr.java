package studying;

import java.util.Arrays;

public class Arr {

  private int temp;

  void select(int[] array) {
    int min_index;

    for (int i = 0; i < array.length-1; i++) {
      min_index = i;
      System.out.println("현재 PASS");

      for (int j = i + 1; j < array.length; j++) {
        System.out.println(array[min_index] + " 와 " + array[j] + " 비교");

        if (array[min_index] > array[j]) {
          min_index = j;
        }
      }

      if (array[i] > array[min_index]) {
        temp = array[i];
        array[i] = array[min_index];
        array[min_index] = temp;
      }
    }
    System.out.println(Arrays.toString(array));
  }

  void bubble(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      System.out.println("현재PASS");
      for (int j = 0; j < array.length - i - 1; j++) {
        System.out.println(array[j] + " 와 " + array[j + 1] + " 비교");
        if (array[j] > array[j + 1]) {
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(array));
  }
}
