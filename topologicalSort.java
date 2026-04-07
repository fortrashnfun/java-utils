import java.util.*;
public class TopologicalSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices 'V':");
        int V = in.nextInt();
        System.out.println("Enter the number of edges 'E':");
        int E = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        System.out.println("Enter the edges (u v) where u->v:");
        for(int i=0;i<E;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(u).add(v);
        }
        topologicalSort(adj, V);
    }
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj, visited, stack, i);
            }
        }
        System.out.println("Topological Sort:");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack, int node){
        visited[node] = true;
        for(Integer neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(adj, visited, stack, neighbour);
            }
        }
        stack.push(node);
    }
}