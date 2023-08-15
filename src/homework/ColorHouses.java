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

    public static int[][] inputMatrix;
    public static int[] combination;

    public static int[] position;
    public static Map<int[],Integer> positionsToValue = new LinkedHashMap<>();

    public static int[] lowersPricePath;
    public static void main (String[] args){
        GetUserInput();
        InitializeCollections();
        Recursion(0, inputMatrix);
        lowersPricePath = FindCheapest(positionsToValue);
        System.out.println("The cheapest way will cost: "+positionsToValue.get(lowersPricePath)+" for combination: "+Arrays.toString(lowersPricePath));
    }

    public static void GetUserInput(){
        Scanner s = new Scanner(System.in);
        System.out.print("Input how many colors is available:");
        int colors = s.nextInt();s.nextLine();
        System.out.print("Input how many houses is to color: ");
        int houses = s.nextInt();s.nextLine();
        inputMatrix = new int[houses][colors];

        System.out.println("Keep putting the costs of all paintings for each house...");
        for (int h=0; h<houses;h++){
            System.out.println("House no. "+(h+1)+": ");
            for (int c=0; c<colors; c++){
                System.out.print("C"+(c+1)+":");
                inputMatrix[h][c] = s.nextInt();
            }
        }
    }

    public static void InitializeCollections(){
        combination = new int[inputMatrix.length];
        position = new int[inputMatrix.length];
        lowersPricePath = new int[inputMatrix.length];
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
            //uwzględnia tylko 3 kolory red, green, blue
    {
        int K = costs[0].length;
        int N = costs.length;
        // Corner Case
        if (N == 0 || K == 0)
            return;

        // Auxiliary 2D dp array
        int dp[][] = new int[N][K]; //pomocnicza tablica. wartości 0


        // Base Case
        for (int i = 0; i < K; i++){
            dp[0][i] = costs[0][i]; //tworzy tablicę dowołania do porównania czyli wartości kosztów pierwszych kolorów dla wszystkich domów
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




