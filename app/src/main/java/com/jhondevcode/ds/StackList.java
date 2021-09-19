package com.ds.dynamic.linear;

public class StackList<T> extends SimpleLinkedList<T> {
	
	public StackList() {
		super();
	}
	
	public T push(T element) {
		this.addEnd(element);
		return element;
	}
	
	public T pop() {
		T data = this.get(this.size() - 1);
		this.removeEnd();
		return data;
	}
	
	public T top() {
		return this.get(this.size() - 1);
	}
	
	public void clear() {
		super.clear();
	}
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public int size() {
		return this.size();
	}

}
