public class Assignment4 {
    public static void main(String[] args) {
        int INF = 9999;
        int[][] graph = {
            { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
            { INF, INF, INF, 0 },
        };
        applyFloydWarshall(graph);
        printGraph(graph, INF);
    }

    static void applyFloydWarshall(int[][] graph){
        int V = graph.length;

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                for(int k=0;k<V;k++){
                    if(graph[i][k] + graph[k][j] < graph[i][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    static void printGraph(int[][] graph,int INF){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j] == INF) System.out.print("INF"+" ");
                else System.out.print(graph[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
