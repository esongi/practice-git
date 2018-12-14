package com.bitcamp.day5;

import java.util.Scanner;

public class AnagramTest {

  public static void main(String[] args) {

    Anagram anagram = new Anagram();

    String first;
    String second;

    Scanner input = new Scanner(System.in);

    System.out.println("첫번째 단어/문장 입력: ");
    first = input.nextLine();

    System.out.println("두번째 단어/문장 입력: ");
    second = input.nextLine();

    anagram.check(first, second);

    input.close();
  }
}
