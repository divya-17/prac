package graphs.detectCycle.undirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class App {


    public static void main(String[] args) {

        int V = 4;
        ArrayList<Integer> adj[] = new ArrayList[V];
        for(int i = 0; i < 4; i++)
            adj[i] = new ArrayList<Integer>();

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        //addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        if (isCyclicDisconntected(adj, V))
            System.out.println("Yes");
        else
            System.out.println("No");
    }



    private static void addEdge(ArrayList<Integer>[] adj, int u, int v) {

        adj[u].add(v);
        adj[v].add(u);
    }

    private static boolean isCyclicDisconntected(ArrayList<Integer>[] adj, int v) {

        boolean visited[] = new boolean[v];
        Arrays.fill(visited,false);

        for (int i = 0; i < v; i++)
            if (!visited[i] &&
                    isCyclicConntected(adj, i, v, visited))
                return true;
        return false;
    }

    private static boolean isCyclicConntected(ArrayList<Integer>[] adj, int s, int V, boolean[] visited) {

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int u = q.poll();
            for (int i = 0; i < adj[u].size(); i++)
            {
                int v = adj[u].get(i);
                if (!visited[v])
                {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
                else if (parent[u] != v)
                    return true;
            }
        }
        return false;
    }

}

