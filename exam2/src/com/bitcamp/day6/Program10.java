package com.bitcamp.day6;

import java.util.Scanner;

public class Program10 {

  public static void main(String[] args) {
    PerfectNumber p = new PerfectNumber();

    Scanner sc = new Scanner(System.in);
    System.out.print("자연수를 입력하세요: ");
    int num = sc.nextInt();
    p.number(num);
    sc.close();
  }
}
