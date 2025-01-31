import java.util.*;

class Graph {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    void addedges(int key, int adjv) {
        if (key == adjv) return; // Prevent self-loops

        graph.putIfAbsent(key, new ArrayList<>());
        
        graph.get(key).add(adjv);
         // Add reverse edge (undirected)
    }

    void printGraph() {
        for (int key : graph.keySet()) {
            System.out.print(key + " -> ");
            System.out.println(String.join(", ", graph.get(key).toString().replaceAll("[\\[\\]]", "")));
        }
    }
}

public class testgraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();

        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        int a, b;
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            g.addedges(a, b);
        }

        sc.close();
        g.printGraph();
    }
}
