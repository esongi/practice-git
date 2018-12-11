package com.bitcamp.day2;

public class Program {
	public static void main(String[] args) throws Exception {
		Lotto lotto = new Lotto();

	//	System.out.println("1.배열로또: " + Arrays.toString(lotto.number()));
		System.out.println("2.set_lotto: " + lotto.setLotto());
		
		//lotto.writeNumber(Arrays.toString(lotto.number()));
		lotto.writeNumber(lotto.setLotto());
	} 
}
