package com.ds.dynamic.linear;

public interface ListModel<T> {
    
    void addStart(T item);

    void addEnd(T item);

    void removeStart();

    void removeEnd();

    void remove(int position);

    default void fill(ListModel<T> list) {
        if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				this.addEnd(list.get(i));
			}
		}
    }

    T get(int position);

    void clear();

    boolean isEmpty();

    int size();

}
