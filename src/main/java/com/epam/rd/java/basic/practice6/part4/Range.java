package com.epam.rd.java.basic.practice6.part4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    private final List<Integer> list;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        list = new ArrayList<>();
        if (reversedOrder) {
            for (int i = secBound; i >= firstBound; i--) {
                list.add(i);
            }
        } else {
            for (int i = firstBound; i <= secBound; i++) {
                list.add(i);
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {
        int index=0;

        @Override
        public boolean hasNext() {
            return index<list.size();
        }

        @Override
        public Integer next() {
            if (index > list.size()) {
                throw new NoSuchElementException();
            }
            return list.get(index++);
        }

    }

}
