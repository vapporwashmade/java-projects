package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum Direction {
    FRONT, RIGHT, UP, BACK, LEFT, DOWN
}

enum Color {
    RED, BLUE, GREEN, WHITE
}

public class Cube {
    private final Map<Direction, Color> configuration = new HashMap<Direction, Color>();

    public Cube(Map<Direction, Color> cube) {
        Object[] keys = cube.keySet().toArray();
        for (int i = 0; i < 6; i++) {
            configuration.put((Direction) keys[i], cube.get(keys[i]));
        }
    }

    /**
     * Accepts a string configuration of the cube and creates an instance of Cube.
     * <p>
     *     The first character in the string represents the color on the front face of the cube, the second character
     *     represents the color on the right face of the cube, the third character in the string represents the color
     *     on the "up"(top) face of the cube, the fourth character represents the color on the back face of the cube,
     *     the fifth character represents the color on the left face of the cube, and the sixth character represents
     *     the color on the "down"(bottom) face of the cube. One way to remember it is "FRUBLD", where F stands for front,
     *     R stands for right, U stands for up, B stands for back, L stands for left, and D stands for down.
     * </p>
     * @param config String to construct the cube from
     */
    public Cube(String config) {
        Direction[] directions = new Direction[]{Direction.FRONT, Direction.RIGHT, Direction.UP, Direction.BACK, Direction.LEFT, Direction.DOWN};
        for (int i = 0; i < 6; i++) {
            if (config.charAt(i) == 'R') {
                configuration.put(directions[i], Color.RED);
            } else if (config.charAt(i) == 'G') {
                configuration.put(directions[i], Color.GREEN);
            } else if (config.charAt(i) == 'B') {
                configuration.put(directions[i], Color.BLUE);
            } else if (config.charAt(i) == 'W') {
                configuration.put(directions[i], Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
//        HashMap<Direction, Color> config = new HashMap<>();
//        config.put(Direction.FRONT, Color.BLUE);
//        config.put(Direction.RIGHT, Color.GREEN);
//        config.put(Direction.UP, Color.GREEN);
//        config.put(Direction.BACK, Color.WHITE);
//        config.put(Direction.LEFT, Color.RED);
//        config.put(Direction.DOWN, Color.BLUE);
        String config = "BRWBWG";
        Cube cube = new Cube(config);
        System.out.println(cube.configuration);
    }

    public Color getFront() {
        return configuration.get(Direction.FRONT);
    }

    public Color getRight() {
        return configuration.get(Direction.RIGHT);
    }

    public Color getUp() {
        return configuration.get(Direction.UP);
    }

    public Color getBack() {
        return configuration.get(Direction.BACK);
    }

    public Color getLeft() {
        return configuration.get(Direction.LEFT);
    }

    public Color getDown() {
        return configuration.get(Direction.DOWN);
    }

    public ArrayList<HashMap<Direction, Color>> rotations() {
        Direction[] directions = new Direction[configuration.size()];
        configuration.keySet().toArray(directions);
        ArrayList<HashMap<Direction, Color>> rotations = new ArrayList<>();
        HashMap<Direction, Color> turn = new HashMap<>(configuration);
        HashMap<Direction, Color> rotation = new HashMap<>(configuration);
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                rotation.put(Direction.FRONT, rotation.get(Direction.RIGHT));
                rotation.put(Direction.RIGHT, rotation.get(Direction.BACK));
                rotation.put(Direction.BACK, rotation.get(Direction.LEFT));
                rotation.put(Direction.LEFT, rotation.get(Direction.FRONT));
                rotations.add(rotation);
            }
            Color temp = configuration.get(directions[i]);
            turn.put();
            rotation = turn;
        }
    }
}
