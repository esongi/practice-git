package com.bitcamp.day4;

public class Shopping {

  public static void main(String[] args) {
    KtTv ktTv = new KtTv();
    Audio audio = new Audio();
    NoteBook noteBook = new NoteBook();


    Buyer buyer = new Buyer();

    buyer.buy(noteBook);

  }

  
}
