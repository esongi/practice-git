package com.bitcamp.day2;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		System.out.print("별 갯수를 입력하세요: ");
		int num = Integer.parseInt(new Scanner(System.in).next());
		new StarCreate().getStar(num);
	}
}
