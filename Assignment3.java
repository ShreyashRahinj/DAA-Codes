import java.util.Arrays;

public class Assignment3 {
    public static void main(String[] args) {
        int w = 20;
        int [][] profitWeight= {{3,10},{5,20},{5,21},{8,30},{4,16}};
        System.out.println(solveKnapsack(w, profitWeight));
        
    }

    static double solveKnapsack(int w,int [][] profitWeight){
        sortAccordingToProfit(profitWeight);
        printArray(profitWeight);
        double maxProfit = 0;
        int currentWeight = 0; 
        for(int pair=0;pair<profitWeight.length;pair++){
            if(profitWeight[pair][0] > w || profitWeight[pair][0]+currentWeight > w){
                int weightToAdd = w - currentWeight;
                double fraction = (double)weightToAdd/(double)profitWeight[pair][0];
                double profitToBeAdded = fraction * (double)profitWeight[pair][1];
                maxProfit += profitToBeAdded;
                break; 
            } else{

                maxProfit += (double)profitWeight[pair][1];
                currentWeight += profitWeight[pair][0];
            }
        }
        return maxProfit;
    }

    static void sortAccordingToProfit(int [][] profitWeight){
        Arrays.sort(profitWeight, (a, b) -> Double.compare((double)b[1]/b[0], (double)a[1]/a[0]));
    }

    static void printArray(int [][] profitWeight){
        for(int[] i:profitWeight){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
