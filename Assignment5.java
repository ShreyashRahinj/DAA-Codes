public class Assignment5 {
    static int recSol(int W,int[] weight,int[] profit,int n){
        if(W==0 || n==0){
            return 0;
        }

        if(weight[n-1] > W) return recSol(W, weight, profit, n-1);

        else return Math.max(profit[n-1] + recSol(W-weight[n-1], weight, profit, n-1), recSol(W, weight, profit, n-1));
    }

    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = profit.length; 
        System.out.println(recSol(W, weight, profit, n));
    }
}
