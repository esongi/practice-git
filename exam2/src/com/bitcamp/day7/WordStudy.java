package com.bitcamp.day7;

import java.util.Scanner;

public class WordStudy {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.print("단어를 입력하세요: ");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine().toUpperCase();

    // 입력값을 모두 대문자로
    //

    int count = 1;
    for (int i = 0; i < str.length(); i++) {
      //

      char temp = str.charAt(i);
      if(temp == str.charAt(i)) {

      }


      if (i != str.length() - 1) {
        if (str.charAt(i) == str.charAt(i + 1)) {
          count++;
        } else if (str.charAt(i) != str.charAt(i + 1)) {
          System.out.print(str.charAt(i) + "" + count);
          count = 1;
        }
      } else {
        System.out.print(str.charAt(i) + "" + count);
      }
    }


  }

}
