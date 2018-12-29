package com.bitcamp.day8;

public class FibonacciSequence {

  private int[] arr;

  void calc(int number) {
    arr = new int[number + 1];
    arr[0] = 0;
    arr[1] = 1;

    for (int i = 2; i < arr.length; i++) {
      arr[i] = arr[i - 2] + arr[i - 1];
    }
    System.out.println("피보나치 " + number + "번째 수는 " + arr[number] + "입니다");
  }

}
