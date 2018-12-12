package com.bitcamp.day3;

public class FinalTest {

	public static void main(String[] args) {
		int[] score = new int[] { 79, 88, 97, 54, 56, 95 };
		int max = score[0];
		int min = score[0];

		for (int i : score) {
			max = i > max ? i : max;
			min = i < min ? i : min;
		}

		System.out.println("max: " + max);
		System.out.println("min: " + min);
	}
}
