package org.apoorv.progfun;

public class PedigreeUnit {
    private char sex = 'u';
    private int allele1 = 0;
    private int allele2 = 0;
    private int phenotype = 0;

    // allele goes 1,2,3 with increasing recessiveness; 1 is dominant to 2 and 3; 2 is dominant to 3; etc.
    public PedigreeUnit(char sex, int allele1, int allele2) {
        this.sex = sex;
        this.allele1 = allele1;
        this.allele2 = allele2;
        this.phenotype = allele1 > allele2 ? allele2 : allele1;
    }

    public static void main(String[] args) {
        PedigreeUnit u = new PedigreeUnit('m', 1, 1);
        System.out.println(u.getPhenotype());
    }

    public char getSex() {
        return sex;
    }

    public int getAllele1() {
        return allele1;
    }

    public int getAllele2() {
        return allele2;
    }

    public int getPhenotype() {
        return phenotype;
    }
}
