package homework;

import java.util.*;


//A builder is looking to build a color of N houses
// that can be of K different colors.
//He has a goal of minimizing cost while ensuring
// that no two neighboring houses are of the same color.
//
//Given an N by K matrix where the nth color and kth column
// represents the cost to build the nth house with kth color,
//return the minimum cost which achieves this goal.
public class ColorHouses {

    public static int[][] inputMatrix = {
            {1,2,3},
            {4,1,6},
            {7,8,1}
    };
    public static int[] combination = new int[inputMatrix.length];

    public static int[] position = new int[inputMatrix.length];
    public static Map<int[],Integer> positionsToValue = new LinkedHashMap<>();

    public static int[] lowersPricePath = new int[inputMatrix.length];
    public static void main (String[] args){
        Recursion(0, inputMatrix);
        lowersPricePath = FindCheapest(positionsToValue);
        System.out.println("The cheapest way will cost: "+positionsToValue.get(lowersPricePath)+" for combination: "+Arrays.toString(lowersPricePath));
    }

    private static int[] FindCheapest(Map<int[],Integer> map) {
        map.entrySet().stream().map(entry -> "Combination: "+Arrays.toString(entry.getKey()) + " costs: " + entry.getValue()).forEach(System.out::println);
        return Collections.min(map.entrySet(),Map.Entry.comparingByValue()).getKey();
    }


    private static void Recursion(int depth, int[][] inputMatrix) {
        for (int i = 0; i < inputMatrix[depth].length; i++) {
            if (depth == 0 || position[depth - 1] != i) {               //if it is just begin or previous position is not the same color
                combination[depth] = inputMatrix[depth][i];             //creating combination array
                position[depth] = i;                                    //creating position array to check the same color - issue
                if (depth == (inputMatrix.length - 1)){                 //logic if it comes to end of the matrix
                    positionsToValue.put(Arrays.copyOf(position, position.length),Arrays.stream(combination).sum());
                } else {
                    Recursion(depth+1,inputMatrix);
                }
            }
        }
    }

    public static void minCost(int costs[][]) //ten kod jest OK bo wykorzystuje Dynamiczne Programowanie ale nie znajduje faktycznie najtańszej opcji
    {
        int K = costs[0].length;
        int N = costs.length;
        // Corner Case
        if (N == 0 || K == 0)
            return;

        // Auxiliary 2D dp array
        int dp[][] = new int[N][K];


        // Base Case
        for (int i = 0; i < K; i++){
            dp[0][i] = costs[0][i];
        }


        for (int i = 1; i < N; i++) {

            // If current house is colored with red the take min cost of previous houses colored with (blue and green)
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2])
                    + costs[i][0];

            // If current house is colored with blue the take min cost of previous houses colored with (red and green)
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2])
                    + costs[i][1];

            // If current house is colored with green the take min cost of previous houses colored with (red and blue)
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1])
                    + costs[i][2];
        }

        // Print the min cost of the last painted house
        System.out.println("Minimal cost from dynamic programming: "+
                Math.min(dp[N - 1][0],
                        Math.min(dp[N - 1][1], dp[N - 1][2])));
    }


}




