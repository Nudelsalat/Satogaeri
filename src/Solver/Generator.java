package Solver;

import java.util.*;

/**
 * Created by Cloud on 11.07.2014.
 */
public class Generator {
    private Shuffler shuffled;
    private Puzzle puzzle;
    private int width;
    private int height;
    private double countrySize = 0.7;

    public Generator(int width, int height, double countrySize, String pathSolver) {
        this.width = width;
        this.height = height;
        this.countrySize = countrySize;
        int countryID = 1;

        puzzle = new Puzzle(width,height,pathSolver);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (puzzle.getCountry(x, y) == -1) {
                    settingBoarders(new Pair(x,y), countryID);
                    countryID++;
                }
            }
        }

        shuffled = new Shuffler(puzzle,width,height);

        puzzle.print();

        Puzzle copy = puzzle.clonePuzzle();
        copy.generateSMTPiping();
    }

    public Puzzle getPuzzle(){
        return shuffled.getShuffledPuzzle();
    }

    public void settingBoarders(Pair pair, int countryID){
        OwnList activeFields = new OwnList();
        OwnList aboutToAdd = new OwnList();
        OwnList countryPairs = new OwnList();
        double probability = this.countrySize;
        Random rand = new Random();

        activeFields.add(pair);
        countryPairs.add(pair);


        while(!activeFields.isEmpty()){
            ListIterator<Pair> activeFieldIterator = activeFields.listIterator();
            Pair nextPair;
            while (activeFieldIterator.hasNext()){
                nextPair = activeFieldIterator.next();
                activeFieldIterator.remove();
                // checking up, down, left, right for possible neighbours
                //up
                int x = nextPair.getElement0();
                int y = nextPair.getElement1()-1;
                if(x >= 0 && y >= 0 && x < this.width && y < this.height && puzzle.getCountry(x, y) < 0){
                    if(rand.nextDouble()<=probability){
                        aboutToAdd.add(new Pair(x,y));
                        if(!countryPairs.contains(new Pair(x,y))) {
                            countryPairs.add(new Pair(x, y));
                        }
                    }
                }
                //down
                x = nextPair.getElement0();
                y = nextPair.getElement1()+1;
                if(x >= 0 && y >= 0 && x < this.width && y < this.height && puzzle.getCountry(x, y) < 0){
                    if(rand.nextDouble()<=probability){
                        aboutToAdd.add(new Pair(x,y));
                        if(!countryPairs.contains(new Pair(x,y))) {
                            countryPairs.add(new Pair(x, y));
                        }
                    }
                }
                //left
                x = nextPair.getElement0()-1;
                y = nextPair.getElement1();
                if(x >= 0 && y >= 0 && x < this.width && y < this.height && puzzle.getCountry(x, y) < 0){
                    if(rand.nextDouble()<=probability){
                        aboutToAdd.add(new Pair(x,y));
                        if(!countryPairs.contains(new Pair(x,y))) {
                            countryPairs.add(new Pair(x, y));
                        }
                    }
                }
                //right
                x = nextPair.getElement0()+1;
                y = nextPair.getElement1();
                if(x >= 0 && y >= 0 && x < this.width && y < this.height && puzzle.getCountry(x, y) < 0){
                    if(rand.nextDouble()<=probability){
                        aboutToAdd.add(new Pair(x,y));
                        if(!countryPairs.contains(new Pair(x,y))) {
                            countryPairs.add(new Pair(x, y));
                        }
                    }
                }
                activeFields.remove(nextPair);
            }
            // reducing the probability of adding a field for the next iteration
            probability = probability*probability;

            ListIterator<Pair> addIterator = aboutToAdd.listIterator();
            while(addIterator.hasNext()) {
                activeFields.add(addIterator.next());
                addIterator.remove();
            }
            aboutToAdd.clear();
        }

        // Adding the new country with its ID to the Puzzle
        Pair[] countryPairsArray = countryPairs.toArray();
        puzzle.setCountry(countryPairsArray, countryID);
        // Randomly pick a Field in the country to define the circle there. The CircleID equals the CountryID. Value is not set yet.
        puzzle.setCircle(countryPairsArray[rand.nextInt(countryPairsArray.length)],-1,countryID);
    }
}
