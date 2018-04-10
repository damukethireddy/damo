package com.damodar.beginer;

public class StackDemo {

	public static void main(String[] args) {

		Stack stack = new Stack(3);
		stack.push(5);
		stack.push(9);
		stack.push(1);
		stack.push(90);
		stack.pop();
		stack.push(90);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

	}

}

interface IStack {

	void pop();

	void push(int element);

	int top();
}

class Stack implements IStack {

	private int elements[] = null;
	private int currentpos = -1;

	@Override
	public void pop() {

		if (currentpos == -1) {

			System.out.println("Empty Stack");
		} else {

			System.out.println("pop operation " + elements[currentpos]);
			currentpos--;

		}

	}

	@Override
	public void push(int element) {

		if (currentpos == elements.length - 1) {
			System.out.println("Stack is Full");

		} else {

			elements[++currentpos] = element;
		}

	}

	@Override
	public int top() {
		return currentpos;
	}

	Stack(int size) {

		elements = new int[size];

	}

}
