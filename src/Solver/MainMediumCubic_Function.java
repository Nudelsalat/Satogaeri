package Solver;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Cloud on 27.05.2014.
 */
public class MainMediumCubic_Function {
    public static void main(String[] args) throws Exception{

        // Satogaeri: Medium; Author: cubic function
        Puzzle puzzle;

        try{
// Open file to read from, named SavedObj.sav.
            FileInputStream loadFile = new FileInputStream("CubicFunction.pzl");

// Create an ObjectInputStream to get objects from save file.
            ObjectInputStream load = new ObjectInputStream(loadFile);

// Now we do the restore.
// readObject() returns a generic Object, we cast those back
// into their original class type.
// For primitive types, use the corresponding reference class.
            puzzle = (Puzzle) load.readObject();
// Close the file.
            load.close(); // This also closes saveFile.
            puzzle.generateSMT_QF_UF_Piping();
            puzzle.generateSMTPiping();
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }
}
