package com.bitcamp.day4;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		System.out.println("10진수 값을 입력해주세요: ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		String full = "";
		String temp = "";
		int[] arr = { 4, 1, 2 };

		while (true) {

			if (num >= 3) {
				if (num % 3 == 0) {
					temp = String.valueOf(arr[0]);
					num = (num - 1) / 3;
				} else if (num % 3 == 1) {
					temp = String.valueOf(arr[1]);
					num = num / 3;
				} else if (num % 3 == 2) {
					temp = String.valueOf(arr[2]);
					num = num / 3;
				}
				System.out.println("temp값" + temp);
				full = temp + full;
			} else {
				if (num != 0) {
					full = num + full;
				}
				System.out.println("num값" + num);
				break;
			}
		}
		sc.close();
		System.out.println("변환된 값은 : " + full);
	}
}
