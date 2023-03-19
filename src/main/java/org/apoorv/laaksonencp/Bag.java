package org.apoorv.laaksonencp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<E extends Comparable<E>> implements Iterable<E> {
    private final List<E> store;

    public Bag() {
        this.store = new ArrayList<>();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < store.size() - 1;
            }

            @Override
            public E next() {
                i++;
                return store.get(i);
            }
        };
    }


    public static void main(String[] args) {
        Bag<Integer> b = new Bag<>();
        Iterator<Integer> iterator = b.iterator();
    }
}


