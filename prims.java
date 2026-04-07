import java.util.*;
public class prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }
        prims(graph, V);
    }
    static void prims(int[][] graph, int V) {
        boolean[] visited = new boolean[V];
        visited[0] = true;
        int edges = 0;
        System.out.println("Edges in MST:");
        while (edges < V - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;
            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!visited[j] && graph[i][j] != 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            System.out.println(u + " - " + v + " : " + min);
            visited[v] = true;
            edges++;
        }
    }
}