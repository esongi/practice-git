package com.bitcamp.day3;

public class FinalGrade {

	public static void main(String[] args) {
		int sum = 0;
		float average = 0f;
		int[] jumsu = { 100, 55, 90, 60, 78 };

		// 연산을 줄이자?
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];

			if (i == jumsu.length - 1) {
				average = (float) sum / jumsu.length;
			}
		}
		System.out.println("1.총 과목수: " + jumsu.length);
		System.out.println("2.점수의 합: " + sum);
		System.out.println("3.점수의 평균을 구하세요: " + average);
	}
}
