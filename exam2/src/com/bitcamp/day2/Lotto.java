package com.bitcamp.day2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private int[] lotto;

	public Lotto() {
		lotto = new int[6];
	}

	public void selectLottoNumber() {
		// 호출하면 번호추출
		for (int i = 0; i < 6; i++) {
			// 난수 추출
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					j--;
					break;
				}
			}
		}
	}

	public void sortLottoNumber() {
		// 정렬
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
	}

	public Set<?> setLotto() {
		Set<Integer> set_lotto = new TreeSet<>();
		for (int i = 0; set_lotto.size() < 6; i++) {
			set_lotto.add((int) (Math.random() * 45) + 1);
		}
		return set_lotto;
	}

	public void writeNumber(String input) throws Exception {
		FileWriter fw = new FileWriter("Lotto.txt");
		PrintWriter fileTxt = null;

		fileTxt = new PrintWriter(fw);
		fileTxt.print(input);
		fileTxt.flush();
		fileTxt.close();
	}

	public void writeNumber(Set<?> input) throws Exception {
		FileWriter fw = new FileWriter("Lotto.txt", true);
		PrintWriter fileTxt = null;

		fileTxt = new PrintWriter(fw);
		fileTxt.print(input);
		fileTxt.flush();
		fileTxt.close();
	}
}
