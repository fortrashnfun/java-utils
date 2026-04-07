import java.util.*;
public class kruskals {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    static void kruskal(int V, List<Edge> edges) {
        Collections.sort(edges, (a, b) -> a.w - b.w);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int count = 0;
        System.out.println("Edges in MST:");
        for (Edge e : edges) {
            int u = e.u;
            int v = e.v;
            if (find(parent, u) != find(parent, v)) {
                System.out.println(u + " - " + v + " : " + e.w);
                union(parent, rank, u, v);
                count++;
            }
            if (count == V - 1) break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }
        kruskal(V, edges);
    }
}