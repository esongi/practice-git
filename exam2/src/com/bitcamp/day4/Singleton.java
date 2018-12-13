package com.bitcamp.day4;

public class Singleton {
  private static Singleton singleton = new Singleton();

  public Singleton() {}

  static Singleton getInstance() {
    return singleton;
  }

}
