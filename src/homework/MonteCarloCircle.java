package homework;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Point{
    double x;
    double y;
    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }
    public boolean isInsideCircle(){
        return Math.sqrt(this.x*this.x+this.y*this.y) <= 1.0;
    }

}
public class MonteCarloCircle implements Callable<Double> {

    static int occurrences = 0;
    static int attempts = 0;

    static double pi = 0;

    static double factPi = 3.141592653589793;


    public static void main (String[] args){
        MonteCarloCircle monteCarloCircle = new MonteCarloCircle();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Double> future = executor.submit(monteCarloCircle);

        try {
            double result = future.get();
            System.out.println("Calculated π: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }


    @Override
    public Double call() throws Exception {
        Random randX = new Random();
        Random randY = new Random();
        do {
            Point p = new Point(randX.nextFloat(-1,1),randY.nextFloat(-1,1));
            if (p.isInsideCircle()) {
                occurrences++;
            }
            attempts++;
            pi = (float) 4 * occurrences / attempts;
        }while (Math.abs(factPi-pi)>0.0000001);
        return pi;
    }
}
