package com.ds.dynamic.linear;

import com.ds.dynamic.linear.nodes.SimpleNodeLinked;

public class SimpleLinkedList<T> implements ListModel<T> {

	private SimpleNodeLinked<T> firstNode;

	private int size;

	public SimpleLinkedList() {
		this.size = 0;
	}

	@Override
	public void addStart(T item) {
		SimpleNodeLinked<T> newNode = new SimpleNodeLinked<>(item);
		if (!this.isEmpty()) {
			newNode.next = this.firstNode;
		}
		this.firstNode = newNode;
		this.size++;
	}

	@Override
	public void addEnd(T item) {
		SimpleNodeLinked<T> newNode = new SimpleNodeLinked<>(item);
		if (!this.isEmpty()) {
			SimpleNodeLinked<T> assistant = this.firstNode;
			while (assistant.next != null) {
				assistant = assistant.next;
			}
			assistant.next = newNode;
		} else {
			this.firstNode = newNode;
		}
		this.size++;
	}

	@Override
	public void removeStart() {
		if (!this.isEmpty()) {
			if (this.firstNode.next != null) {
				this.firstNode.value = null;
				this.firstNode = firstNode.next;
			} else {
				this.firstNode.value = null;
				this.firstNode = null;
			}
			this.size--;
		} else {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
	}

	@Override
	public void removeEnd() {
		if (!this.isEmpty()) {
			if (this.firstNode.next != null) {
				SimpleNodeLinked<T> assistant = this.firstNode;
				while (assistant.next.next != null) {
					assistant = assistant.next;
				}
				SimpleNodeLinked<T> endNode = assistant.next;
				endNode.value = null;
				assistant.next = null;
			} else {
				this.firstNode.value = null;
				this.firstNode = null;
			}
			this.size--;
		} else {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
	}

	@Override
	public void remove(int position) {
		if(!this.isEmpty()) {
			if (position == 0) {
				this.removeStart();
			} else if (position == this.size() - 1) {
				this.removeEnd();
			} else {
				if (position < this.size()){
					SimpleNodeLinked<T> assistant = this.firstNode;
					int counter = 0;
					while (counter < position - 1) {
						assistant = assistant.next;
						counter++;
					}
					SimpleNodeLinked<T> searchedNode = assistant.next;
					searchedNode.value = null;
					assistant.next = searchedNode.next;
					searchedNode.next = null;
					this.size--;
				} else {
					throw new IndexOutOfBoundsException(position + " is out of range.");
				}
			}
		} else {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
	}

	@Override
	public T get(int position) {
		if (!this.isEmpty()) {
			if (position < this.size) {
				SimpleNodeLinked<T> assistant = this.firstNode;
				int counter = 0;
				while (counter < position) {
					assistant = assistant.next;
					counter++;
				}
				return assistant.value;
			} else {
				throw new IndexOutOfBoundsException(position + " is out of range.");
			}
		} else {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.firstNode == null && this.size() == 0;
	}

	@Override
	public void clear() {
		this.firstNode = null;
		this.size = 0;
	}

	@Override
	public String toString() {
		if(!this.isEmpty()) {
			SimpleNodeLinked<T> assistant = this.firstNode;
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			while (assistant != null) {
				builder.append(assistant.value.toString()).append(",").append(" ");
				assistant = assistant.next;
			}
			builder.append("]");
			return builder.toString().replace(", ]", "]");
		} else {
			return "[]";
		}
	}

}
