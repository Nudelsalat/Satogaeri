package Solver;

/**
 * Created by Cloud on 21.11.2014.
 */
public class Properties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println("\n"+System.getProperty("os.name"));
    }
}