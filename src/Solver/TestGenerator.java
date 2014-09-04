package Solver;

/**
 * Created by Cloud on 11.07.2014.
 */
public class TestGenerator {
    public static void main(String args[]) {
        Generator gen = new Generator(10,15,0.8);
        Puzzle puzzle = gen.getPuzzle();
        puzzle.generateSMTPiping();
        puzzle.print();
    }
}
