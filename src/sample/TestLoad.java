package sample;

import Solver.OwnList;
import Solver.Pair;
import Solver.Puzzle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Cloud on 23.10.2014.
 */
public class TestLoad {

    public static void main(String args[]) {
        Puzzle puzzle;

        try{
// Open file to read from, named SavedObj.sav.
            FileInputStream loadFile = new FileInputStream("test.pzl");

// Create an ObjectInputStream to get objects from save file.
            ObjectInputStream load = new ObjectInputStream(loadFile);

// Now we do the restore.
// readObject() returns a generic Object, we cast those back
// into their original class type.
// For primitive types, use the corresponding reference class.
            puzzle = (Puzzle) load.readObject();
// Close the file.
            load.close(); // This also closes saveFile.
            for(int x =0; x<puzzle.getWidth();x++){
                for(int y = 0; y<puzzle.getHeight();y++){
                    OwnList pairs = new OwnList();
                    for(int i =0; i<puzzle.getWidth();i++) {
                        for (int j = 0; j < puzzle.getHeight(); j++) {
                            if(puzzle.getCountry(x,y) == puzzle.getCountry(i,j)){
                                pairs.add(new Pair(i,j));
                            }
                        }
                    }
                    Pair[] pairs2 = pairs.toArray();
                    puzzle.setNeighbors(pairs2, x, y);
                }
            }
            puzzle.print();

            puzzle.generateSMTPiping();

            puzzle.print();
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
        }

    }
}
