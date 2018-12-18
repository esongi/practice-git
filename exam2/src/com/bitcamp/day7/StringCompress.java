package com.bitcamp.day7;

public class StringCompress {

  void compress(String str) {
    int count = 1;
    for (int i = 0; i < str.length(); i++) {
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
