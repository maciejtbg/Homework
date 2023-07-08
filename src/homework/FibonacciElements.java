package homework;

import java.util.LinkedList;
import java.util.List;

public class FibonacciElements {
    private static int GetFibonacciStringElements(int number) {
        int result = 0;
        if (number <=0){
            throw new RuntimeException("Number of elements must be greater than 0");
        } else if (number == 1){
            result = 0;
        } else {
            List<Integer> fibonacciList = new LinkedList<>();
            fibonacciList.add(0);
            fibonacciList.add(1);
            for (int i = 2; i<=number-1; i++){//odejmuję 1 ponieważ pierwszy element to 0
                int nextFibonacciElement = fibonacciList.get(i-2)+ fibonacciList.get(i-1);
                fibonacciList.add(nextFibonacciElement);
            }

            //wypisanie wszystkich elementów ciągu
            for (int i = 0; i<fibonacciList.size(); i++){
                System.out.println("Element "+i+": "+fibonacciList.get(i));
            }

            result = fibonacciList.get(fibonacciList.size()-1);
        }
        return result;
    }

    public static void main (String[] args){
        System.out.println(GetFibonacciStringElements(10));
    }


}
