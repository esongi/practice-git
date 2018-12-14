package com.bitcamp.day5;

import java.util.Arrays;

public class Anagram {

  private int[] temp1;
  private int[] temp2;
  private int temp_no;

  int[] transfer(String firstInput) {
    // 변환하고 넣는과정
    // 정렬
    int[] temp_arr = new int[firstInput.length()];

    for (int i = 0; i < temp_arr.length; i++) {
      int num = (int) (firstInput.toUpperCase().charAt(i));
      temp_arr[i] = num;
    }

    for (int i = 1; i < temp_arr.length - 1; i++) {
      for (int j = 0; j < temp_arr.length - i; j++) {
        if (temp_arr[j] > temp_arr[j + 1]) {
          temp_no = temp_arr[j + 1];
          temp_arr[j + 1] = temp_arr[j];
          temp_arr[j] = temp_no;
        }
      }
    }
    System.out.println(Arrays.toString(temp_arr));
    return temp_arr;
  }

  void check(String input1, String input2) {
    // 비교
    temp1 = transfer(input1);
    temp2 = transfer(input2);

    for (int i = 0; i < temp1.length; i++) {
      if (!(temp1[i] == temp2[i])) {
        System.out.println("두 문장은 틀립니다");
        break;
      }
      if (i == temp1.length - 1) {
        if ((temp1[i] == temp2[i])) {
          System.out.println("두 문장은 Anagram 입니다 ");
        }
      }
    }

  }
}
