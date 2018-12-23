package com.bitcamp.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordStudy {

  public static void main(String[] args) {
    System.out.println("단어를 입력하세요: ");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine().toUpperCase();
    Map<Object, Integer> map = new HashMap<>();
    int count = 0;

    for (int i = 0; i < str.length(); i++) {

      // map 안에 key 없을경우(처음 넣을때)
      if (!map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), count);
      }
      if (map.containsKey(str.charAt(i))) {
        map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
      }
      // map 안에 key 있을경우(이미 추가되어있을경우) + 지금 값이 이전값과 같은 경우
      if (map.containsKey(str.charAt(i)) && str.charAt(i) == str.charAt(i) - 1) {
        // key의 값 1증가
        map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
      }
    }

    Object[] count_arr = map.values().toArray();
    Object[] key_arr = map.keySet().toArray();

    Arrays.sort(count_arr);

    for (int j = 0; j < key_arr.length; j++) {
      if (count_arr[count_arr.length - 2] == count_arr[count_arr.length - 1]) {
        System.out.println("??");
        break;
      }
      if (map.get(key_arr[j]) == count_arr[count_arr.length - 1]) {
        System.out.println("이게 답이다!! >> " + key_arr[j]);
      }
    }
    sc.close();
  }
}

