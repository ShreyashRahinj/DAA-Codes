public class Assignment8 {
    
    static int tsp(int[][] graph,boolean[] v,int n,int currentPos,int cost,int count,int ans){

        if(count == n && graph[currentPos][0] >0){
            ans = Math.min(ans, cost + graph[currentPos][0]);
            return ans;
        }
        for(int i=0;i<n;i++){
            if(v[i] == false && graph[currentPos][i] >0){
                v[i] = true;

                ans = tsp(graph, v, n, i, cost+graph[currentPos][i], count+1, ans);

                v[i] = false;
            }
        }
        return ans;
    }
   
    

    public static void main(String[] args) {
        int n = 4;
 
        int[][] graph = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};
 
        boolean[] v = new boolean[n];

        int ans = Integer.MAX_VALUE;

        v[0] = true;

        ans = tsp(graph,v,n,0,0,1,ans);

        System.out.println(ans);
        
    }

    
}
