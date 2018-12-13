package com.bitcamp.day4;

public class Product {
  int price;
  int bonus_point;

  public Product() {

  }

  Product(int price) {
    this.price = price;
    this.bonus_point = (int) (this.price / 10.0);
  }
  
}
