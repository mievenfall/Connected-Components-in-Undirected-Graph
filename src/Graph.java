/***************************************************************/
/* Evelyn Vu                                                   */
/* Login ID: evu                                               */
/* CS 3310, Spring 2024                                        */
/* Programming Assignment 1                                    */
/* Graph class: functions to contruct a graph                  */
/***************************************************************/

import java.util.*;

class Graph {
	private int numVertices;;
	private Map<Integer, List<Integer>> graph;
	private boolean[] visited;
	private List<Set<Integer>> components;

	// Constructor
	Graph(int numVertices)
	{
		this.numVertices = numVertices;
		this.graph = new HashMap<Integer, List<Integer>>();
		this.visited = new boolean[numVertices+1];
		this.components = new ArrayList<Set<Integer>>();
	}

    /**************************************************************/
    /* Method: addVertex                                          */
    /* Purpose: Add all vertices to the graph                     */
    /**************************************************************/
	
    void addVertex() {
        for (int i = 1; i < numVertices+1; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

	/**************************************************************/
    /* Method: addEdge                                            */
    /* Purpose: Add all vertices to the graph                     */
    /* Parameters:                                                */
    /* String[] edges: List of edges given from the input file    */
    /**************************************************************/
    
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

    /**************************************************************/
    /* Method: connectComponent                                   */
    /* Purpose: Using depth-first search to connect vertices that */
    /*          linked with an edge to create connect components  */
    /**************************************************************/

	void connectComponent() {
        for(int i = 1; i <= numVertices; i++) {

            // If vertex i is not visited yet, 
            // create a new set of component
            if(!visited[i]) {
                Set<Integer> component = new HashSet<Integer>();

                // Perform dfs to add more vertex (if possible)
                // to create a connected component
                dfs(graph, i, visited, component);

                // Add the connected component to the list of components
                components.add(component);
            }
        }
    }

    /**************************************************************/
    /* Method: dfs                                                */
    /* Purpose: Depth-first search algorithm to create            */
    /*          connectect components                             */
    /* Parameters:                                                */
    /* Map<Integer, List<Integer>> graph: the undirected graph    */
    /* int vertex: the current vertex of the graph                */
    /* boolean[] visited: list of visited vertice                 */
    /* Set<Integer> component: the current component we are       */
    /*                         trying to connect                  */
    /**************************************************************/

	void dfs(Map<Integer, List<Integer>> graph, int vertex, 
                           boolean[] visited, Set<Integer> component) {
        
        // Mark the current vertex as visited
        visited[vertex] = true;
        
        // Add the vertex to the set of component
        component.add(vertex);

        // Recur for all the neighbor of that vertex
        for(int neighbor : graph.get(vertex)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }

    /**************************************************************/
    /* Method: printResult                                        */
    /* Purpose: Print the result in proper format                 */
    /**************************************************************/

	void printResult() {

        // Initialize StringBuilder to work on building a string
        StringBuilder resultBuilder = new StringBuilder();

        // Format every connected component as {x y z}
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

        // Finalize string and output to the user
        String result = resultBuilder.toString();
        System.out.println(components.size() + " connected components: " + result);
        System.out.println();
    }
}
