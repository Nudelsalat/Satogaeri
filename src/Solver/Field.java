package Solver;

/**
 * Created by Cloud on 27.05.2014.
 */
public class Field {
    private Pair[] neighbors;
    private int country = -1;
    private int inhabitant = -1;
    private boolean inhabited = false;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private int circle_trace = -1;
    private int circle_value = -1;


    public Field(){
    }

    public void setCountry(int c, Pair[] neighbors){
        this.neighbors = neighbors;
        country = c;
    }

    public int getCountry(){
        return country;
    }

    public Pair[] getNeighbors(){
        return neighbors;
    }
    public void setInhabitant(int inhab){
        inhabitant = inhab;
    }

    public int setInhabitant(){
        return inhabitant;
        // TODO: set boolean of neighbors true
    }

    public boolean getInhabitation(){
        return inhabited;
    }

    public void inhabitated(){
        inhabited = true;
    }

    public void uninhabitated(){
        inhabited = false;
    }

    public void setLeft(Boolean bool){
        left = bool;
    }

    public void setRight(Boolean bool){
        right = bool;
    }

    public void setup(Boolean bool){
        up = bool;
    }

    public void setDown(Boolean bool){
        down = bool;
    }

    public int getCircle_trace(){
        return circle_trace;
    }

    public void setCircle_trace(int circle){
        circle_trace = circle;
    }

    public void setCircle(int value, int id_trace){
        circle_trace = id_trace;
        circle_value = value;
    }

    public int getCircle_value(){
        return circle_value;
    }

    public void setCircle_value(int circle){
        circle_value = circle;
    }


    public String toString(){
        if(10 > circle_value && circle_value >= 0){
            return  " "+String.valueOf(circle_value)+" ";
        }else if(10 <= circle_value){
            return  " "+String.valueOf(circle_value);
        }else if(circle_value == -2) {
            return " # ";
        }else if (left){
            return " < ";
        }else if (right){
            return " > ";
        }else if (up){
            return " ^ ";
        }else if (down){
            return " v ";
        }else if(circle_trace >= 0){
            return " * ";
        }
        return "   ";
    }
}
