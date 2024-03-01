import java.util.*;


class Graph {
	private int numVertices;;
	private Map<Integer, List<Integer>> graph;
	private boolean[] visited;
	private List<Set<Integer>> components;

	// constructor
	Graph(int numVertices)
	{
		this.numVertices = numVertices;
		// define the size of array as
		// number of vertices
		this.graph = new HashMap<Integer, List<Integer>>();
		this.visited = new boolean[numVertices+1];
		this.components = new ArrayList<Set<Integer>>();
	}

	void addVertex() {
        for (int i = 1; i < numVertices+1; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

	// Adds an edge to an undirected graph
	void addEdge(String[] edges) {
        for(int i = 1; i < edges.length; i++) {
            String[] edge = edges[i].substring(1, edges[i].length()-1).split(",");

            // Two vertices of an edge
            int u = Integer.parseInt(edge[0]); 
            int v = Integer.parseInt(edge[1]);
            
            // Add edge from u to v
            graph.get(u).add(v);

            // Since graph is undirected, add edge from v to u
            graph.get(v).add(u);
        }
    }

	void connectComponent() {
        for(int i = 1; i <= numVertices; i++) {
            if(!visited[i]) {
                Set<Integer> component = new HashSet<Integer>();
                dfs(graph, i, visited, component);
                components.add(component);
            }
        }
    }
	void dfs(Map<Integer, List<Integer>> graph, int v, 
                           boolean[] visited, Set<Integer> component) {
        // DFS implementation
        visited[v] = true;
        component.add(v);
        for(int neighbor : graph.get(v)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }
	void printResult() {
        StringBuilder resultBuilder = new StringBuilder();
        for(Set<Integer> component : components) {
            resultBuilder.append("{");
            boolean prev = true;
            for (Integer v : component) {
                if (prev != true) {
                    resultBuilder.append(" ");
                }
                resultBuilder.append(v);
                prev = false;
            }
            resultBuilder.append("} ");
        }

        String result = resultBuilder.toString();
        System.out.println(components.size() + " connected components: " + result);
        System.out.println();
    }
	// Driver code
}
