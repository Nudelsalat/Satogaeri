package Solver;

/**
 * Created by Cloud on 11.07.2014.
 */
public class TestGenerator {
    public static void main(String args[]) {
        Generator gen = new Generator(5,10,0.8);
        Puzzle puzzle = gen.getPuzzle();
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        puzzle.generateSMTPiping();
        puzzle.print();
    }
}
