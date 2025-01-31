import java.util.*;

// graph1 class definition
class graph1 {
    // A map to store the adjacency list: key -> node, value -> set of adjacent nodes
    private final Map<String, Set<String>> adjList = new HashMap<>();

    // Method to add an edge between two nodes (u and v)
    public void addEdge(String u, String v) {
        // Ensure both u and v are in the map and add each other as neighbors
        adjList.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        adjList.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    // Method to find mutual neighbors for a given node
    public Set<String> mutualNeighbors(String node) {
        // If the node doesn't exist in the adjacency list, return an empty set
        if (!adjList.containsKey(node)) return Collections.emptySet();

        // Retrieve the neighbors of the given node
        Set<String> neighbors = adjList.get(node);
        
        // A set to store mutual neighbors
        Set<String> mutuals = new HashSet<>();

        // Flag to track the first neighbor's adjacent set (to initialize mutuals)
        boolean firstSet = true;

        // Iterate over each neighbor of the given node
        for (String neighbor : neighbors) {
            // If the neighbor is not in the adjacency list, continue to the next one
            if (!adjList.containsKey(neighbor)) continue;

            // Get the set of neighbors for this current neighbor
            Set<String> adj = new HashSet<>(adjList.get(neighbor));
            // Remove the original node from the neighbor's list (we don't want to include the original node)
            adj.remove(node);
            
            // If this is the first set of neighbors, initialize the mutuals set
            if (firstSet) {
                mutuals.addAll(adj); // Add all neighbors of the first neighbor
                firstSet = false;    // Mark that we've processed the first neighbor's set
            } else {
                // For subsequent neighbors, retain only the common elements (mutual neighbors)
                mutuals.retainAll(adj);
            }
        }

        // Return the set of mutual neighbors (it could be empty if no mutuals were found)
        return mutuals;
    }

    // Main method to test the graph1 and mutual neighbor finding
    public static void main(String[] args) {
        // Create a new graph1
        graph1 g = new graph1();
        Scanner sc = new Scanner(System.in);

        // // Add edges to the graph1 (create connections between nodes)
        // g.addEdge("A", "D");
        // g.addEdge("A", "B");
        // g.addEdge("B", "E");
        // g.addEdge("B", "C");
        // g.addEdge("D", "F");
        // g.addEdge("F", "D"); // Ensure bidirectional edge (D <-> F)
        // g.addEdge("F", "B"); // Adding this connection to match expected result (F is connected to B)

        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        String a, b;
        for (int i = 0; i < n; i++) {
            a = sc.next();
            b = sc.next();
            g.addEdge(a, b);
        }

        // Print out the mutual neighbors of node "A" (neighbors of A are D and B)
        System.out.println("Mutual neighbors of A's adjacent vertices: " + g.mutualNeighbors("A"));
    }
}
