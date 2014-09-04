package Solver;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cloud on 01.09.2014.
 */
public class Shuffler {
    private Puzzle puzzle;
    private int width;
    private int height;

    public Shuffler(Puzzle puzzle, int width, int height){
        this.puzzle = puzzle;
        this.width = width;
        this.height = height;
        boolean only_one_solution = false;

        Pair[] circle_id_init_pos = getAllCircles();

        //Todo: programm move, which should randomly choose a direction and length. where length ends if obstacle is reached.
        while(!only_one_solution) {
            for (int i = 0; i < circle_id_init_pos.length; i++) {
                move_circles(circle_id_init_pos[i]);
            }
            //todo: sent puzzle to solver
            only_one_solution = true;
        }
    }

    public void move_circles(Pair circle_id_init_pos){
        Random rand = new Random();
        int x = circle_id_init_pos.getElement0();
        int y = circle_id_init_pos.getElement1();
        int circleID = puzzle.getCircle_trace(x,y);
        int direction = rand.nextInt(4); // number between 0-3 up=0 down=1 left=2 right=3
        boolean reached_obstacle = false;

        // delete old circle-position. -1 is equivalent to "no-circle". also the Circle_trace is set to -1 because later
        // later on we will check if on the fields are any traces (for they are not to be crossed)
        puzzle.setCircle(circle_id_init_pos,-1,-1);
        //up
        if(direction==0){
            int movement;
            if(y==0) {
                movement = 0;
            }else{
                movement = rand.nextInt(y); // number between 0 and y. where y is the distance to the top boarder of the puzzle.
            }
            for(int i = 0; i<=movement && !reached_obstacle;i++){
                if(puzzle.getCircle_trace(x,y-i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y - i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y-i+1),i-1,circleID);
                    reached_obstacle = true;
                }
            }
            if(!reached_obstacle){
                puzzle.setCircle(new Pair(x,y+movement),movement,circleID);
            }
        }
        //down
        else if(direction == 1){
            int movement;
            if((height - y) - 1==0) {
                movement = 0;
            }else {
                movement = rand.nextInt((height - y) - 1); // number between 0 and the distance to the bottom boarder of the puzzle.
            }
//todo verify
            for(int i = 0; i<=movement && !reached_obstacle;i++){
                if(puzzle.getCircle_trace(x,y+i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y + i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y+i-1),i-1,circleID);
                    reached_obstacle = true;
                }
            }
            if(!reached_obstacle){
                puzzle.setCircle(new Pair(x,y+movement),movement,circleID);
            }
        }
        //left
        else if(direction == 2){
            int movement;
            if(x==0) {
                movement = 0;
            }else {
                movement = rand.nextInt(x); // number between 0 and x. where x is the distance to the left boarder of the puzzle.
            }
//todo verify
            for(int i = 0; i<=movement && !reached_obstacle;i++){
                if(puzzle.getCircle_trace(x,y-i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y - i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y-i+1),i-1,circleID);
                    reached_obstacle = true;
                }
            }
            if(!reached_obstacle){
                puzzle.setCircle(new Pair(x,y+movement),movement,circleID);
            }
        }
        //right
        else if(direction == 3){
            int movement;
            if((width - y) - 1==0) {
                movement = 0;
            }else {
                movement = rand.nextInt((width - x) - 1); // number between 0 and the distance to the right boarder of the puzzle.
            }
//todo verify
            for(int i = 0; i<=movement && !reached_obstacle;i++){
                if(puzzle.getCircle_trace(x,y+i)==-1) {
                    puzzle.setCircle_trace(new Pair(x, y + i), circleID);
                } else{
                    puzzle.setCircle(new Pair(x,y+i-1),i-1,circleID);
                    reached_obstacle = true;
                }
            }
            if(!reached_obstacle){
                puzzle.setCircle(new Pair(x,y+movement),movement,circleID);
            }
        }
    }

    /**
     * Goes through the whole Puzzle and saves the positions of all Circle_Ids
     *
     * returns: Pair[] with the Circle_Id positions
     */
    public Pair[] getAllCircles(){

        List<Pair> allCircles = new LinkedList<Pair>();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(puzzle.getCircle_trace(x,y) >= 0){
                    allCircles.add(new Pair(x,y));
                }
            }
        }
        Pair[] allCirclesArray = new Pair[allCircles.size()];
        int i = 0;
        for(Pair countryPair : allCircles){
            allCirclesArray[i]=countryPair;
            i++;
        }
        return allCirclesArray;
    }
}
