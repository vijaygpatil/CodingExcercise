package com.selfPractice.linkedList;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;

	public ListNode(T data, ListNode<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
}
