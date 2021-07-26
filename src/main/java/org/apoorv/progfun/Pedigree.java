package org.apoorv.progfun;

import java.util.ArrayList;

public class Pedigree {
    ArrayList<Object> pedigree = new ArrayList<Object>();


    public Pedigree(int generations) {
        int maxOffspring = 3;
        for (int i = 0; i < generations; i++) {

        }
    }

    private static PedigreeUnit createRandomPedigree() {
        int allele1 = (int)(Math.random() * 2);
        int allele2 = (int)(Math.random() * 2);
        return null;
    }

    public static void main(String[] args) {
        createRandomPedigree();
    }
}
