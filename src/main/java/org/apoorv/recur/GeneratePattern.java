package org.apoorv.recur;

public class GeneratePattern {
    public static void main(String[] args) {
        generateParagraph();
    }

    public static int choose(int n) {
        return 1 + (int) (Math.random() * n);
    }

    private static void generateName() {
        switch (choose(5)) {
            case 1:
                System.out.print("Dick");
                break;
            case 2:
                System.out.print("Jane");
                break;
            case 3:
                System.out.print("Sally");
                break;
            case 4:
                System.out.print("Spot");
                break;
            case 5:
                System.out.print("Puff");
                break;
        }
    }

    private static void generatePattern1() {
        System.out.print("This is ");
        generateName();
    }

    private static void generatePattern2() {
        System.out.print("See ");
        generateName();
    }

    private static void generatePattern3() {
        System.out.print("See ");
        generateName();
        System.out.print(" ");
        generateVerb();
    }

    private static void generateVerb() {
        switch (choose(3)) {
            case 1:
                System.out.print("run");
                break;
            case 2:
                System.out.print("jump");
                break;
            case 3:
                System.out.print("play");
                break;
        }
    }

    public static void generateSentence() {
        switch (choose(4)) {
            case 1:
                generatePattern1();
                break;
            case 2:
                generatePattern2();
                break;
            case 3:
                generatePattern3();
                break;
            case 4:
                generatePattern4();
                break;
        }
        System.out.println(".");
    }

    private static void generatePattern4() {
        generateName();
        System.out.print(" ");
        generateTransitiveVerb();
        System.out.print(" ");
        generateNounPhrase();
    }

    private static void generateTransitiveVerb() {
        switch (choose(4)) {
            case 1:
                System.out.print("watched");
                break;
            case 2:
                System.out.print("liked");
                break;
            case 3:
                System.out.print("found");
                break;
            case 4:
                System.out.print("hit");
                break;
        }
    }

    private static void generateNoun() {
        switch (choose(3)) {
            case 1:
                System.out.print("ball");
                break;
            case 2:
                System.out.print("stick");
                break;
            case 3:
                System.out.print("house");
                break;
        }
    }

    private static void generateAdjective() {
        switch (choose(4)) {
            case 1:
                System.out.print("big");
                break;
            case 2:
                System.out.print("little");
                break;
            case 3:
                System.out.print("red");
                break;
            case 4:
                System.out.print("green");
                break;
        }
    }

    private static void generateNounPhrase() {
        switch (choose(2)) {
            case 1:
                generateName();
                break;
            case 2:
            System.out.print("the ");
            generateModifiedNoun();
            break;
        }
    }

    private static void generateModifiedNoun() {
        switch (choose(2)) {
            case 1:
                generateNoun();
                break;
            case 2:
                generateAdjective();
                System.out.print(" ");
                generateModifiedNoun();
                break;
        }
    }

    public static void generateParagraph() {
        switch (choose(2)) {
            case 1:
                generateSentence();
                break;
            case 2:
                generateSentence();
                generateParagraph();
                break;
        }
    }
}