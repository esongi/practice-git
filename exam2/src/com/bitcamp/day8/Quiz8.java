package com.bitcamp.day8;

import java.util.Scanner;

public class Quiz8 {
  public static void main(String[] args) {

    System.out.print("수를 입력하세요: ");
    Scanner sc = new Scanner(System.in);
    int number = Integer.parseInt(sc.nextLine());
    FibonacciSequence sequence = new FibonacciSequence();
    
    sequence.calc(number);
    
    sc.close();
  }
}
