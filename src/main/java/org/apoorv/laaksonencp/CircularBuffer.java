package org.apoorv.laaksonencp;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class CircularBuffer implements Queue<Integer> {
    public static void main(String[] args) {

    }

    public CircularBuffer() {
        new CircularBuffer(10);
    }

    //TODO: create +1 capacity and "sacrifice" 1 place to distinguish empty/full
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity + 1];
    }

    private int capacity;
    private int[] buffer;
    private int head = 0;
    private int tail = 1;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return tail == (head + 1) % capacity;
    }

    public boolean isFull() {
        return tail == head;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean add(Integer integer) {
        if (isFull()) {
            throw new BufferOverflowException();
        }
        buffer[tail] = integer;
        tail++;
        tail %= capacity;
        return true;
    }

    @Override
    public boolean offer(Integer integer) {
        if (isFull()) {
            return false;
        }
        buffer[tail] = integer;
        tail++;
        tail %= capacity;
        return true;
    }

    @Override
    public Integer remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        head++;
        head %= capacity;
        return buffer[head];
    }

    @Override
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        head++;
        head %= capacity;
        return buffer[head];
    }

    @Override
    public Integer element() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Buffer is empty");
        }
        return buffer[(head + 1) % capacity];
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return buffer[(head + 1) % capacity];
    }
}
