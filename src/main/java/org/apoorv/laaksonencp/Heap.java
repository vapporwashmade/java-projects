package org.apoorv.laaksonencp;

import java.util.Arrays;

public class Heap {
    public static void heapify(int[] a) {
        // start from end and skip leaves
        for (int i = a.length - 1; i >= 0; i--) {
            if (2 * i + 1 >= a.length) {
                continue;
            }
            // check heap property
            if (2 * i + 2 >= a.length) {
                if (a[2 * i + 1] > a[i]) {
                    // swap
                    int temp = a[i];
                    a[i] = a[2 * i + 1];
                    a[2 * i + 1] = temp;
                }
            } else {
                // swap greater and a[i] and sift a[i] down
                siftdown(a, i);
            }
        }
    }

    private static void siftdown(int[] heap, int index) {
        // find larger node
        int larger = -1;
        if (2 * index + 2 >= heap.length) {
            if (2 * index + 1 < heap.length) {
                larger = 2 * index + 1;
            }
        } else {
            if (heap[2 * index + 2] > heap[2 * index + 1]) {
                larger = 2 * index + 2;
            } else {
                larger = 2 * index + 1;
            }
        }
        while (larger > 0 && heap[larger] > heap[index]) {
            // swap
            int temp = heap[larger];
            heap[larger] = heap[index];
            heap[index] = temp;
            // recalculate larger and index
            index = larger;
            larger = -1;
            if (2 * index + 2 >= heap.length) {
                if (2 * index + 1 < heap.length) {
                    larger = 2 * index + 1;
                }
            } else {
                if (heap[2 * index + 2] > heap[2 * index + 1]) {
                    larger = 2 * index + 2;
                } else {
                    larger = 2 * index + 1;
                }
            }
        }
    }

    public static void add() {

    }

    public static boolean checkHeap(int[] heap, int start, int end) {
        
    }
    public static boolean checkHeap(int[] heap) {
        if (heap.length % 2 == 0) {
            int l = ((heap.length - 2) / 2);
            for (int i = 0; i < l; i++) {
                if (heap[i] < heap[2 * i + 1] || heap[i] < heap[2 * i + 2]) {
                    return false;
                }
            }
            return heap[l] >= heap[l * 2 + 1];
        }
        int l = ((heap.length - 2) / 2);
        for (int i = 0; i < l; i++) {
            if (heap[i] < heap[2 * i + 1] || heap[i] < heap[2 * i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int l = 20;
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = (int) (Math.random()*2*l);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(checkHeap(a));
        heapify(a);
        System.out.println(Arrays.toString(a));
        System.out.println(checkHeap(a));
    }
}
