package Solver;

import java.io.Serializable;

/**
 * Created by Cloud on 27.05.2014.
 */
public class Pair implements Serializable {
    private final int element0;
    private final int element1;

    public Pair(int element0, int element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public int getElement0() {
        return element0;
    }

    public int getElement1() {
        return element1;
    }
}
