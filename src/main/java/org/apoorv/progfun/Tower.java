package org.apoorv.progfun;

import java.util.ArrayList;
import java.util.HashMap;

public class Tower {
    private ArrayList<Cube> tower = new ArrayList<>();
    HashMap<Direction, Color[]> sides = new HashMap<>();

    public Tower(Cube[] cubes) {
        Color[] frontSide = new Color[cubes.length];
        Color[] rightSide = new Color[cubes.length];
        Color[] backSide = new Color[cubes.length];
        Color[] leftSide = new Color[cubes.length];
        for (int i = 0; i < cubes.length; i++) {
            frontSide[i] = cubes[i].getFront();
            rightSide[i] = cubes[i].getRight();
            backSide[i] = cubes[i].getBack();
            leftSide[i] = cubes[i].getLeft();
            tower.add(cubes[i]);
        }
        sides.put(Direction.FRONT, frontSide);
        sides.put(Direction.RIGHT, rightSide);
        sides.put(Direction.BACK, backSide);
        sides.put(Direction.LEFT, leftSide);
    }

    // checks whether the tower is sane or not
    // a tower is sane if each of the four sides of the tower has no repeating colors along that tower side's length
    // for example, one side of the tower (composed of the corresponding faces of all the cubes composing the tower) cannot have two red colors
//    public boolean isSane() {
//
//    }
}
