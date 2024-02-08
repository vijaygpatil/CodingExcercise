package com.selfPractice.linkedList;

public class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data, LinkedListNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
}
