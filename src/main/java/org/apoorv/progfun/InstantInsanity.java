package org.apoorv.progfun;

import java.util.Arrays;

// TODO: do this thing dude
public class InstantInsanity {

    // cubes are constructed such that if 1 is at the front, 2 is at the right, 3 at top, 4 at back, 5 at left, 6 at bottom
    char[] cube1 = new char[]{'B', 'R', 'G', 'W', 'B', 'G'};
    char[] cube2 = new char[]{'G', 'B', 'R', 'W', 'W', 'G'};
    char[] cube3 = new char[]{'W', 'R', 'W', 'R', 'B', 'G'};
    char[] cube4 = new char[]{'R', 'R', 'B', 'G', 'R', 'W'};

//    public static char[] findIterative(char[][] cubes) {
//        for (int i = 0; i < cubes.length; i++) {
//            for ()
//        }
//    }

    // turns the cube so that a new face becomes the front face
//    private static char[] rotateCube(char[] cube) {
//        char[] result = new char[6];
//        if (turnUp) {
//            result[0] = cube[5];
//            result[1] = cube[1];
//            result[2] = cube[0];
//            result[3] = cube[2];
//            result[4] = cube[4];
//            result[5] = cube[3];
//        } else {
//            result[0] = cube[4];
//            result[1] = cube[0];
//            result[2] = cube[2];
//            result[3] = cube[1];
//            result[4] = cube[3];
//            result[5] = cube[5];
//        }
//        turnUp = !turnUp;
//        return result;
//    }

    // turns the cube keeping the front and back faces in their original places, i.e., it rotates it along the front-back axis
    private static char[] turnCube(char[] cube) {
        char[] result = new char[6];
        result[0] = cube[0];
        result[1] = cube[5];
        result[2] = cube[1];
        result[3] = cube[3];
        result[4] = cube[2];
        result[5] = cube[4];
        return result;
    }

    public static void main(String[] args) {
        char[] cube = new char[]{'1', '2', '3', '4', '5', '6'};
        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(cube));
            for (int j = 0; j < 3; j++) {
                cube = turnCube(cube);
                System.out.println(Arrays.toString(cube));
            }
//            cube = rotateCube(cube);
        }
    }
}
