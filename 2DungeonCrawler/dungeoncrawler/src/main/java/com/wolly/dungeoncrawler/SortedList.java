package com.wolly.dungeoncrawler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortedList<E> extends LinkedList<E> {
	private static final long serialVersionUID = 4871797622763970617L;
	private Comparator<E> _comparator;

    public SortedList(final Comparator<E> pComparator) {
        this._comparator = pComparator;
    }

    // Orders the list whenever a new item get's added.
    @Override
    public boolean add(E e) {
    	final boolean result = super.add(e);
    	Collections.sort(this, _comparator);
    	return result;
    }
    
      // Orders the list whenever the list iterates.
//    @Override
//    public Iterator<E> iterator() {
//        Collections.sort(this, _comparator);
//        return super.iterator();
//    }
}