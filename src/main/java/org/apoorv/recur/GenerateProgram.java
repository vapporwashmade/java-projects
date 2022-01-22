package org.apoorv.recur;

// ADD-DOC: recur
public class GenerateProgram {
    public static void main(String[] args) {
        generateMethodName();
    }

    private static String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static int choose(int n) {
        return 1 + (int) (Math.random() * n);
    }

    public static String generateVariable(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        switch (choose(2)) {
            case 1:
                stringBuilder.append(letters[(int) (Math.random() * 26)]);
                break;
            case 2:
                stringBuilder.append(letters[(int) (Math.random() * 26)]);
                return generateVariable(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }

    public static void generateCondition(String variable) {
        if (variable == null) {
            System.out.print(generateVariable(""));
        } else {
            System.out.print(variable);
        }
        switch (choose(5)) {
            case 1:
                System.out.print(" == ");
                break;
            case 2:
                System.out.print(" > ");
                break;
            case 3:
                System.out.print(" < ");
                break;
            case 4:
                System.out.print(" >= ");
                break;
            case 5:
                System.out.print(" <= ");
                break;
        }
        switch (choose(2)) {
            case 1:
                System.out.print(choose(100));
                break;
            case 2:
                System.out.print(generateVariable(""));
                break;
        }
    }

    public static void generateIf() {
        System.out.print("if (");
        generateCondition(null);
        System.out.print(") {\n\t");
        generateStatement();
        System.out.print("\n}");
    }

    public static void generateStatementPattern1() {
        System.out.print("int ");
        System.out.print(generateVariable(""));
        System.out.print(" = ");
        System.out.print(choose(100));
        System.out.print(";");
    }

    public static void generateStatementPattern2() {
        System.out.print("String ");
        System.out.print(generateVariable(""));
        System.out.print(" = \"");
        System.out.print(generateVariable(""));
        System.out.print("\";");
    }

    public static void generateStatement() {
        switch (choose(2)) {
            case 1:
                generateStatementPattern1();
                break;
            case 2:
                generateStatementPattern2();
                break;
        }
    }

    public static void generateFor() {
        String iterator = generateVariable("");
        String direction = incOrDec();
        System.out.print("for (" + iterator + " = " + choose(100) + "; ");
        generateCondition(iterator);
        System.out.print("; " + iterator + direction + ") {\n\t");
        generateStatement();
        System.out.print("\n}");
    }

    private static String incOrDec() {
        switch (choose(2)) {
            case 1:
                return "++";
            case 2:
                return "--";
        }
        return "++";
    }

    public static void generateMethod() {
        switch (choose(3)) {
            case 1:
//                System.out.print("\t");
                generateFor();
                break;
            case 2:
//                System.out.print("\t");
                generateIf();
                break;
            case 3:
//                System.out.print("\t");
                generateStatement();
                break;
        }
        System.out.print("\n");
        switch (choose(3)) {
            case 1:
            case 2:
                generateMethod();
                break;
            case 3:
                break;
        }
    }

    public static void generateMethodName() {
        String className = generateVariable("");
        System.out.print("public static void ");
        System.out.print(className + "() {\n");
        generateMethod();
        System.out.print("}");
    }
}
