package org.apoorv.laaksonencp;

import java.util.ArrayList;

/**
 * A BitVector class I implemented that is essentially a bit set, a set of bits that grows and shrinks as needed
 */
public class ABitVector {
    private final ArrayList<Long> bv = new ArrayList<>();

    public ABitVector() {
        this(0);
    }

    public ABitVector(int numBits) {
        for (int i = 0; i < numBits / 64 + 1; i++) {
            bv.add(0L);
        }
    }

    /**
     * @see #set(int, int, boolean)
     * @param bitIndex
     */
    public void set(int bitIndex) {
        set(bitIndex, bitIndex + 1, true);
    }

    public void set(int bitIndex, boolean value) {
        set(bitIndex, bitIndex + 1, value);
    }

    public void set(int fromIndex, int toIndex) {
        set(fromIndex, toIndex, true);
    }

    /**
     * Sets the bits from fromIndex, inclusive, to toIndex, exclusive, to zero if value is false and to one if value is true.
     * @param fromIndex
     * @param toIndex
     * @param value
     */
    public void set(int fromIndex, int toIndex, boolean value) {
        int i = fromIndex / 64;
        long[] toCompare = getCompareStr(fromIndex, toIndex);
        for (int j = 0; j < toCompare.length; j++) {
            if (value) {
                bv.set(i + j, bv.get(i + j) | toCompare[j]);
            } else {
                bv.set(i + j, bv.get(i + j) & ~toCompare[j]);
            }
        }
    }

    public void clear(int bitIndex) {
        set(bitIndex, bitIndex + 1, false);
    }

    public void clear(int fromIndex, int toIndex) {
        set(fromIndex, toIndex, false);
    }

    public void flip(int bitIndex) {
        flip(bitIndex, bitIndex + 1);
    }

    public void flip(int fromIndex, int toIndex) {
        int i = fromIndex / 64;
        long[] toCompare = getCompareStr(fromIndex, toIndex);
        for (int j = 0; j < toCompare.length; j++) {
            bv.set(i + j, bv.set(i + j, bv.get(i + j) ^ toCompare[j]));
        }
    }

    public void and(ABitVector vector) {
        long[] elems = vector.toLongArray();
        for (int i = 0; i < bv.size(); i++) {
            bv.set(i, bv.get(i) & elems[i]);
        }
    }

    public void or(ABitVector vector) {
        long[] elems = vector.toLongArray();
        for (int i = 0; i < bv.size(); i++) {
            bv.set(i, bv.get(i) | elems[i]);
        }
    }

    public void xor(ABitVector vector) {
        long[] elems = vector.toLongArray();
        for (int i = 0; i < bv.size(); i++) {
            bv.set(i, bv.get(i) ^ elems[i]);
        }
    }

    public long[] toLongArray() {
        long[] arr = new long[bv.size()];
        for (int i = 0; i < bv.size(); i++) {
            arr[i] = bv.get(i);
        }
        return arr;
    }

    public String toBitString() {
        StringBuilder sB = new StringBuilder();
        for (Long aLong : bv) {
            sB.append(String.format("%64s", Long.toBinaryString(aLong)).replace(' ', '0'));
            sB.append(' ');
        }
        return sB.toString();
    }

    private long[] getCompareStr(int fromIndex, int toIndex) {
        int trailzeros = fromIndex % 64;
        long[] toCompare = new long[((fromIndex % 64) + (toIndex - fromIndex) + (64 - toIndex % 64)) / 64];
        int i = toCompare.length - 1;
        int ones = toIndex - fromIndex;
        while (ones > 64) {
            toCompare[i] = ~0;
            ones -= 64;
            i--;
        }
        if (ones > 0) {
            long r = (1L << ones) - 1;
            r <<= (trailzeros);
            toCompare[i] = r;
        }
        return toCompare;
    }

    public static void main(String[] args) {
        ABitVector x = new ABitVector(120);
        System.out.println(x.toBitString());
        x.set(54, 64, true);
        System.out.println(x.toBitString());
    }
}
