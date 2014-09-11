package Solver;

/**
 * Created by Cloud on 27.05.2014.
 */
public class Main_Testing {
    public static void main(String[] args) throws Exception{
        //System.setOut(new PrintStream(new FileOutputStream("../CVC4/cvc4-1.3-win32-opt.txt")));

        // Satogaeri: Medium; Author: Z_H
        Puzzle puzzle = new Puzzle(5,10);

        Pair[] country1 = new Pair[5];
        country1[0] = new Pair(0,0);
        country1[1] = new Pair(1,0);
        country1[2] = new Pair(1,1);
        country1[3] = new Pair(2,1);
        country1[4] = new Pair(1,2);
        puzzle.setCountry(country1 ,1);

        Pair[] country2 = new Pair[3];
        country2[0] = new Pair(2,0);
        country2[1] = new Pair(3,0);
        country2[2] = new Pair(3,1);
        puzzle.setCountry(country2 ,2);

        Pair[] country3 = new Pair[1];
        country3[0] = new Pair(4,0);
        puzzle.setCountry(country3, 3);

        puzzle.setCountryBlock(new Pair(0,1), new Pair(0,3), 4);

        Pair[] country5 = new Pair[4];
        country5[0] = new Pair(4,1);
        country5[1] = new Pair(4,2);
        country5[2] = new Pair(3,2);
        country5[3] = new Pair(2,2);
        puzzle.setCountry(country5 ,5);

        Pair[] country6 = new Pair[7];
        country6[0] = new Pair(1,3);
        country6[1] = new Pair(2,3);
        country6[2] = new Pair(0,4);
        country6[3] = new Pair(1,4);
        country6[4] = new Pair(2,4);
        country6[5] = new Pair(2,5);
        country6[6] = new Pair(2,6);
        puzzle.setCountry(country6 ,6);

        puzzle.setCountryBlock(new Pair(3,3), new Pair(4,5),7);

        Pair[] country8 = new Pair[5];
        country8[0] = new Pair(0,5);
        country8[1] = new Pair(1,5);
        country8[2] = new Pair(0,6);
        country8[3] = new Pair(1,6);
        country8[4] = new Pair(0,7);
        puzzle.setCountry(country8 ,8);

        Pair[] country9 = new Pair[10];
        country9[0] = new Pair(3,6);
        country9[1] = new Pair(4,6);
        country9[2] = new Pair(1,7);
        country9[3] = new Pair(2,7);
        country9[4] = new Pair(3,7);
        country9[5] = new Pair(4,7);
        country9[6] = new Pair(1,8);
        country9[7] = new Pair(2,8);
        country9[8] = new Pair(3,8);
        country9[9] = new Pair(4,8);
        puzzle.setCountry(country9 ,9);

        Pair[] country10 = new Pair[4];
        country10[0] = new Pair(0,8);
        country10[1] = new Pair(0,9);
        country10[2] = new Pair(1,9);
        country10[3] = new Pair(2,9);
        puzzle.setCountry(country10 ,10);

        puzzle.setCountryBlock(new Pair(3,9), new Pair(4,9),11);


        puzzle.setCircle(new Pair(2,0), -2, 1);
        puzzle.setCircle(new Pair(3,0), 1, 2);
        puzzle.setCircle(new Pair(2,1), 0, 3);
        puzzle.setCircle(new Pair(1,2), 2, 4);
        puzzle.setCircle(new Pair(2,4), 1, 5);
        puzzle.setCircle(new Pair(0,6), 5, 6);
        puzzle.setCircle(new Pair(3,6), 3, 7);
        puzzle.setCircle(new Pair(4,6), -2, 8);
        puzzle.setCircle(new Pair(0,7), 0, 9);
        puzzle.setCircle(new Pair(1,9), 0, 10);
        puzzle.setCircle(new Pair(4,9), 0, 11);

        puzzle.setCircle_trace(new Pair(4,0),2);

        puzzle.setCircle_trace(new Pair(0,1),6);
        puzzle.setCircle_trace(new Pair(0,2),6);
        puzzle.setCircle_trace(new Pair(0,3),6);
        puzzle.setCircle_trace(new Pair(0,4),6);
        puzzle.setCircle_trace(new Pair(0,5),6);

        puzzle.setCircle_trace(new Pair(2,2),4);
        puzzle.setCircle_trace(new Pair(3,2),4);

        puzzle.setCircle_trace(new Pair(1,4),5);

        puzzle.setCircle_trace(new Pair(3,3),7);
        puzzle.setCircle_trace(new Pair(3,4),7);
        puzzle.setCircle_trace(new Pair(3,5),7);


        puzzle.print();

        puzzle.generateSMTPiping();

        puzzle.print();
        // TODO: Pipe output to CVC4 and get that output... http://stackoverflow.com/questions/18669245/how-can-i-pipe-the-java-console-output-to-file-without-java-web-start
    }
}
