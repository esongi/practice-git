package com.bitcamp.day4;

public class Buyer {

  private int my_money;
  private int my_bonus;
  Product[] cart;
  
  public Buyer() {
  }
  
  Buyer(int my_money, int my_bonus) {
    this.my_money = my_money;
    this.my_bonus = my_bonus;
    cart = new Product[10];
  }

  // 구매를 하면 카트에 담는다
  void buy(Product n) {

    if (this.my_money < n.price) {
      System.out.println("잔액이 부족합니다");
      return;
    }

    // 실구매 행위
    this.my_money -= n.price;
    this.my_bonus += n.bonus_point;
    System.out.println("구매한 물건: " + n.toString());
    System.out.println("현재 잔액: " + this.my_money);
    System.out.println("현재 보너스포인트: " + this.my_bonus);
    
    // 카트에 제품을 넣는다
  }
  
  void summary() {
    Cart cart = new Cart();
    System.out.print("현재 구입한 제품은: ");
    for (int i = 0; i < cart.cart_products.length || cart.cart_products[i] == null; i++) {
      
     // System.out.println(cart.cart_products[i]+":"+cart.ca);
      
    }

  }

}
