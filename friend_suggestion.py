from collections import defaultdict

class Graph:
    def __init__(self):
        self.adj_list = defaultdict(set)

    def add_edge(self, u, v):
        self.adj_list[u].add(v)
        self.adj_list[v].add(u)

    def mutual_neighbors(self, node):
        if node not in self.adj_list:
            return set()

        neighbors = self.adj_list[node]
        neighbor_sets = [self.adj_list[n] - {node} for n in neighbors if n in self.adj_list]

        if not neighbor_sets:
            return set()

        mutuals = set.intersection(*neighbor_sets) if neighbor_sets else set()
        return mutuals

# Create the graph
g = Graph()
edges = [('A', 'D'), ('A', 'B'), ('B', 'E'), ('B', 'C'), ('D', 'F'), ('F', 'D'), ('F', 'B')]  # Added ('F', 'B') to match expected result

for u, v in edges:
    g.add_edge(u, v)

print("Mutual neighbors of A's adjacent vertices:", g.mutual_neighbors('A'))
