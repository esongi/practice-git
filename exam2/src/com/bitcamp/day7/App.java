package com.bitcamp.day7;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("문자 입력 >> ");
    String str = sc.nextLine();
    StringCompress compress = new StringCompress();
    compress.compress(str);
    sc.close();
  }
}
