package com.bitcamp.day5;

import java.util.Scanner;

public class IdCheck {

  public static void main(String[] args) {

    System.out.println("주민등록번호를 14자리를 입력해주세요(-포함): ");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    char check_number = id.charAt(7);

    checkLength(id);
    checkIndex(check_number);
    checkGender(check_number);

    sc.close();
  }

  static boolean checkLength(String input) {

    boolean check = false;
    check = input.length() == 14 ? true : false;
    return check;

  }

  static void checkIndex(char input) {
    if (input != '1' || input != '2' || input != '3' || input != '4') {
      System.out.println("알맞는 성별이 확인되었습니다");
    }
  }

  static void checkGender(char input) {

    if (input == '1' || input == '3') {
      System.out.println("남자");
    } else if (input == '2' || input == '4') {
      System.out.println("여자");
    }
  }

}
