package com.bitcamp.day5;

public class GenericStack<T> {
	// 스택은 항아리로 비유한다
	// 마지막에 넣은 값부터 차례로 꺼낼수있는 구조
	// 그래서 스택의 구조를 Last In, First Out이라고 해서 LIFO

	private T[] stackArr;
	private int count;

	public GenericStack() {
		this(Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public GenericStack(int size) {
		stackArr = (T[]) new Object[size];
		count = 0;
	}

	public boolean empty() {
		return count == 0 ? true : false;
	}

	public boolean full() {
		return (stackArr.length == count + 1) ? true : false;
	}

	public void push(T i) {
		if (full()) {
			System.out.println("스택이 꽉 찼습니다");
		} else {
			stackArr[count] = i;
			count++;
		}
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (empty()) {
			return null;
		} else {
			Object tmp = stackArr[count - 1];
			stackArr[count] = null;
			count--;
			return (T) tmp;
		}
	}

}
