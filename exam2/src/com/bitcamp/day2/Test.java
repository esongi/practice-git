package com.bitcamp.day2;

import java.util.Scanner;

public class Test {
	Scanner sc = new Scanner(System.in);
	private int num = Integer.parseInt(sc.nextLine());
	private int[] arr;

	public Test() {
		arr = new int[num];
	}

	public void input() {

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}

		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				// System.out.println(j + " 과 " + (j + 1) + " 을 비교");
				if (arr[j] > arr[j + 1]) {
					int temp_no = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp_no;
				}
				// System.out.println((i) + "번째:" + java.util.Arrays.toString(arr));
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("버블정렬 후: " + arr[i]);
		}

	}
}
