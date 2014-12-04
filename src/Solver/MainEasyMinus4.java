package Solver;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Cloud on 27.05.2014.
 */
public class MainEasyMinus4 {
    public static void main(String[] args) throws Exception{

        // Satogaeri: Medium; Author: cubic function
        Puzzle puzzle;

        try{
// Open file to read from, named SavedObj.sav.
            FileInputStream loadFile = new FileInputStream("easy-4.pzl");

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
            puzzle.generateSMT_QF_UF_Piping();
            puzzle.generateSMTPiping();
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }
}
