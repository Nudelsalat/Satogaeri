package Puzzles;

import Solver.Pair;
import Solver.Puzzle;

/**
 * Created by Cloud on 28.05.2014.
 */
public class EasyAquabluePuzzle {
    private Puzzle puzzle;

    public EasyAquabluePuzzle(){
        // Satogaeri: Easy; Author: Aquablue
        this.puzzle = new Puzzle(10, 10);

        Pair[] country1 = new Pair[4];
        country1[0] = new Pair(0,0);
        country1[1] = new Pair(1,0);
        country1[2] = new Pair(2,0);
        country1[3] = new Pair(0,1);
        puzzle.setCountry(country1 ,1);

        Pair[] country2 = new Pair[6];
        country2[0] = new Pair(3,0);
        country2[1] = new Pair(4,0);
        country2[2] = new Pair(1,1);
        country2[3] = new Pair(2,1);
        country2[4] = new Pair(3,1);
        country2[5] = new Pair(4,1);
        puzzle.setCountry(country2 ,2);

        Pair[] country3 = new Pair[4];
        country3[0] = new Pair(5,0);
        country3[1] = new Pair(6,0);
        country3[2] = new Pair(7,0);
        country3[3] = new Pair(5,1);
        puzzle.setCountry(country3 ,3);

        Pair[] country4 = new Pair[5];
        country4[0] = new Pair(8,0);
        country4[1] = new Pair(9,0);
        country4[2] = new Pair(9,2);
        country4[3] = new Pair(9,1);
        country4[4] = new Pair(9,3);
        puzzle.setCountry(country4, 4);

        puzzle.setCountryBlock(new Pair(6,1), new Pair(8,2), 5);

        puzzle.setCountryBlock(new Pair(0,2), new Pair(0,5), 6);

        Pair[] country7 = new Pair[6];
        country7[0] = new Pair(1,2);
        country7[1] = new Pair(1,3);
        country7[2] = new Pair(1,4);
        country7[3] = new Pair(2,2);
        country7[4] = new Pair(3,2);
        country7[5] = new Pair(4,2);
        puzzle.setCountry(country7, 7);

        Pair[] country8 = new Pair[6];
        country8[0] = new Pair(5,2);
        country8[1] = new Pair(5,3);
        country8[2] = new Pair(6,3);
        country8[3] = new Pair(7,3);
        country8[4] = new Pair(8,3);
        country8[5] = new Pair(8,4);
        puzzle.setCountry(country8,8);

        puzzle.setCountryBlock(new Pair(2,3), new Pair(3,4), 9);


        Pair[] country10 = new Pair[5];
        country10[0] = new Pair(4,3);
        country10[1] = new Pair(4,4);
        country10[2] = new Pair(4,5);
        country10[3] = new Pair(3,5);
        country10[4] = new Pair(2,5);
        puzzle.setCountry(country10, 10);


        Pair[] country11 = new Pair[5];
        country11[0] = new Pair(5,6);
        country11[1] = new Pair(5,5);
        country11[2] = new Pair(5,4);
        country11[3] = new Pair(7,4);
        country11[4] = new Pair(6,4);
        puzzle.setCountry(country11, 11);

        Pair[] country12 = new Pair[6];
        country12[0] = new Pair(1,5);
        country12[1] = new Pair(1,6);
        country12[2] = new Pair(2,6);
        country12[3] = new Pair(3,6);
        country12[4] = new Pair(4,6);
        country12[5] = new Pair(4,7);
        puzzle.setCountry(country12, 12);

        puzzle.setCountryBlock(new Pair(9,4), new Pair(9,7), 13);

        puzzle.setCountryBlock(new Pair(6,5), new Pair(7,6), 14);

        Pair[] country15 = new Pair[6];
        country15[0] = new Pair(8,5);
        country15[1] = new Pair(8,6);
        country15[2] = new Pair(8,7);
        country15[3] = new Pair(7,7);
        country15[4] = new Pair(6,7);
        country15[5] = new Pair(5,7);
        puzzle.setCountry(country15, 15);

        Pair[] country16 = new Pair[5];
        country16[0] = new Pair(0,6);
        country16[1] = new Pair(0,7);
        country16[2] = new Pair(0,8);
        country16[3] = new Pair(0,9);
        country16[4] = new Pair(1,9);
        puzzle.setCountry(country16, 16);

        puzzle.setCountryBlock(new Pair(1,7), new Pair(3,8), 17);

        Pair[] country18 = new Pair[4];
        country18[0] = new Pair(2,9);
        country18[1] = new Pair(3,9);
        country18[2] = new Pair(4,9);
        country18[3] = new Pair(4,8);
        puzzle.setCountry(country18, 18);

        Pair[] country19 = new Pair[6];
        country19[0] = new Pair(8,8);
        country19[1] = new Pair(7,8);
        country19[2] = new Pair(6,8);
        country19[3] = new Pair(5,8);
        country19[4] = new Pair(6,9);
        country19[5] = new Pair(5,9);
        puzzle.setCountry(country19, 19);

        Pair[] country20 = new Pair[4];
        country20[0] = new Pair(7,9);
        country20[1] = new Pair(8,9);
        country20[2] = new Pair(9,9);
        country20[3] = new Pair(9,8);
        puzzle.setCountry(country20, 20);


        puzzle.setCircle(new Pair(1,0), 0, 1);
        puzzle.setCircle(new Pair(4,0), 1, 2);
        puzzle.setCircle(new Pair(6,0), 1, 3);
        puzzle.setCircle(new Pair(8,0), 1, 4);
        puzzle.setCircle(new Pair(0,1), 3, 5);
        puzzle.setCircle(new Pair(7,1), -2,6);
        puzzle.setCircle(new Pair(5,2), 1, 7);
        puzzle.setCircle(new Pair(9,2), 2, 8);
        puzzle.setCircle(new Pair(0,3), 3, 9);
        puzzle.setCircle(new Pair(6,3), 3, 10);
        puzzle.setCircle(new Pair(3,4), 2, 11);
        puzzle.setCircle(new Pair(1,5),-2, 20);
        puzzle.setCircle(new Pair(4,5), 1, 12);
        puzzle.setCircle(new Pair(7,5), 1, 13);
        puzzle.setCircle(new Pair(2,7),-2, 14);
        puzzle.setCircle(new Pair(1,9), 2, 15);
        puzzle.setCircle(new Pair(0,9), 2, 16);
        puzzle.setCircle(new Pair(3,9), 2, 17);
        puzzle.setCircle(new Pair(6,9), 1, 18);
        puzzle.setCircle(new Pair(8,8), 1, 19);

        puzzle.print();

        puzzle.generateSMTPiping();

        puzzle.print();
    }
    public Puzzle getPuzzle(){
        return this.puzzle;
    }
}
