package com.ds.dynamic.linear;

import com.ds.dynamic.linear.nodes.SimpleNodeLinked;

public class SimplyLinkedCircularList<T> implements ListModel<T> {

    private SimpleNodeLinked<T> firstNode;

    private int size;
    
    public SimplyLinkedCircularList() {
        this.size = 0;
    }

    @Override
    public void addStart(T item) {
        SimpleNodeLinked<T> newNode = new SimpleNodeLinked<>(item);
        if (!this.isEmpty()) {
            newNode.next = this.firstNode;
            this.firstNode = newNode;
        } else {
            this.firstNode = newNode;
            this.firstNode.next = newNode;
        }
        this.size++;
    }

    @Override
    public void addEnd(T item) {
        SimpleNodeLinked<T> newNode = new SimpleNodeLinked<>(item);
        if (!this.isEmpty()) {
            SimpleNodeLinked<T> assistant = this.firstNode;
            do {
                assistant = assistant.next;
            } while (assistant.next != this.firstNode);
            newNode.next = this.firstNode;
            assistant.next = newNode;
        } else {
            this.firstNode = newNode;
            newNode.next = newNode;
        }
        this.size++;
    }

    @Override
    public void removeStart() {
        if (!this.isEmpty()) {
            if (this.size > 1) {
                SimpleNodeLinked<T> assistant = this.firstNode;
                do {
                    assistant = assistant.next;
                } while (assistant.next.next != this.firstNode);
                SimpleNodeLinked<T> newFirst = this.firstNode.next;
                assistant.next = newFirst;
                this.firstNode = newFirst;
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
            SimpleNodeLinked<T> assistant = this.firstNode;
            do {
                assistant = assistant.next;
            } while (assistant.next.next != this.firstNode);
            SimpleNodeLinked<T> searched = assistant.next;
            searched.value = null;
            assistant.next = searched.next;
            searched.next = null;
            this.size--;
        } else {
            throw new IndexOutOfBoundsException("The list is empty.");
        }
    }

    @Override
    public void remove(int position) {
        if (!this.isEmpty()) {
            if (position == 0) {
                this.removeStart();
            } else if (position == this.size - 1) {
                this.removeEnd();
            } else {
                if (position < this.size) {
                    SimpleNodeLinked<T> assistant = this.firstNode;
                    int counter = 0;
                    while (counter < position - 1) {
                        assistant = assistant.next;
                        counter++;
                    }
                    assistant.next = assistant.next.next;
                    this.size--;
                } else {
                    throw new IndexOutOfBoundsException(position + " out of range.");
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
                throw new IndexOutOfBoundsException(position + " out of range.");
            }
        } else {
            throw new IndexOutOfBoundsException("The list is empty.");
        }
    }

    @Override
    public void clear() {
        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (!this.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            SimpleNodeLinked<T> assistant = this.firstNode;
            do {
                builder.append(assistant.value.toString()).append(",").append(" ");
                assistant = assistant.next;
            } while (assistant != this.firstNode);
            builder.append("]");
            return builder.toString().replace(", ]", "]");
        } else {
            return "[]";
        }
    }

}
