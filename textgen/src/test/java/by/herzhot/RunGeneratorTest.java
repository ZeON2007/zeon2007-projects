package by.herzhot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class RunGeneratorTest {

    private int[][] world = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    class Hero {

        private int x = 0;
        private int y = 0;

        private class Brain {

        }

        public boolean stepUp() {
            if (y + 1 <= 3) {
                y++;
                return true;
            }
            return false;
        }
        public boolean stepRight() {
            if (x + 1 <= 3) {
                x++;
                return true;
            }
            return false;
        }
        public boolean stepDown() {
            if (y - 1 >= 0) {
                y--;
                return true;
            }
            return false;
        }
        public boolean stepLeft() {
            if (x - 1 >= 0) {
                x--;
                return true;
            }
            return false;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    class Goal {
        private int x = 3;
        private int y = 3;

        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    }

    class Conductor {
        private int time = 0;
        private Hero hero = new Hero();
        private Goal goal = new Goal();

        public void update() {

        }
    }

    @Test
    public void test() {
        int size = 100;
        short[] ortVer = new short[size*size];
        short[] ortHor = new short[size*size];
        short[] digVer = new short[size*size];
        short[] digHor = new short[size*size];
        short[] digSize = new short[size*size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ortHor[i * size + j] = (short) j;
                ortVer[i * size + j] = (short) i;
                digHor[i * size + j] = (short) (j + i);
                digVer[i * size + j] = (short) (j + size - 1 - i);
                digSize[i * size + j] = (short) (size + Math.min(j < size/2 ? j : size - 1 - j, i < size/2 ? i : size - 1 - i) * 2);
            }
        }

        Map<Short, Integer> ortVerMap = new HashMap<>(size);
        Map<Short, Integer> ortHorMap = new HashMap<>(size);
        Map<Short, Integer> digVerMap = new HashMap<>(size);
        Map<Short, Integer> digHorMap = new HashMap<>(size);


        for (int k = 0; k < ortVer.length; k++) {
            System.out.println(ortHor[k] + " | " + ortVer[k] + " | " + digHor[k] + " | " + digVer[k] + " | " + digSize[k]);
            if (!ortHorMap.containsKey(ortHor[k])
                    && !ortVerMap.containsKey(ortVer[k])
                    && !digHorMap.containsKey(digHor[k])
                    && !digVerMap.containsKey(digVer[k])
                    ) {
                ortHorMap.put(ortHor[k], k);
                ortVerMap.put(ortVer[k], k);
                digHorMap.put(digHor[k], k);
                digVerMap.put(digVer[k], k);
            }
        }

        System.out.println("--------------------");
//        short[] digSize1 = digSize.clone();
//        Arrays.sort(digSize1);
//        System.out.println(Arrays.toString(digSize1));
//        System.out.println(Arrays.toString(digSize));
        System.out.println(ortHorMap.size());
    }
}