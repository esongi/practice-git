package com.bitcamp.day2;

import java.util.Scanner;

public class Test {
	Scanner sc = new Scanner(System.in);
	private int num = Integer.parseInt(sc.nextLine());
	private int[] arr;
	private int temp_no;

	public Test() {
		arr = new int[num];
	}

	public void input() {

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				if (arr[i] > arr[j]) {
					temp_no = arr[i];
					arr[i] = arr[j];
					arr[j] = temp_no;
				}
			}
			System.out.println(arr[i]);
		}
	}
}
