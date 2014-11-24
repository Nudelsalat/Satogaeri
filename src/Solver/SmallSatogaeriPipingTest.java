package Solver;

/**
 * Created by Cloud on 27.05.2014.
 */
public class SmallSatogaeriPipingTest {
    public static void main(String[] args) throws Exception{
        //System.setOut(new PrintStream(new FileOutputStream("../CVC4/cvc4-1.3-win32-opt.txt")));

        // Satogaeri: Medium; Author: Z_H
        Puzzle puzzle = new Puzzle(3,2,"cvc4-1.3-win32-opt.exe --lang smt -m --statistics");

        puzzle.setCountryBlock(new Pair(0,0), new Pair(0,1), 1);
        puzzle.setCountryBlock(new Pair(1,0), new Pair(1,1), 2);
        puzzle.setCountryBlock(new Pair(2,0), new Pair(2,1), 3);

        puzzle.setCircle(new Pair(0,0), 0, 1);
        puzzle.setCircle(new Pair(0,1), 2, 2);
        puzzle.setCircle(new Pair(2,0), 1, 16);

        puzzle.print();

        puzzle.generateSMTPiping();

        puzzle.print();
    }
}
