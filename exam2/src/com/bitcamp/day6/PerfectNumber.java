package com.bitcamp.day6;

import java.util.Arrays;

public class PerfectNumber {
  private int[] perfect_arr;
  private static int count_num = 0;

  PerfectNumber() {
    perfect_arr = new int[10];
  }

  void number(int num) {
    int sum = 0;

    for (int j = 2; j <= num; j++) {

      for (int i = 1; i <= j / 2; i++) {
        if (j % i == 0) {
          sum += i;
        }
        // System.out.println("현재 i: " + i + ", 현재 j: " + j + " sum :" + sum);
        // 값 넣기
        if (i == j / 2) {
          if (j == sum) {
            perfect_arr[count_num] = j;
            count_num++;
            // System.out.println("총:" + sum);
          }
          // sum 초기화
          sum = 0;
        }
      }
    }

    System.out.println(Arrays.toString(perfect_arr));
  }
}
