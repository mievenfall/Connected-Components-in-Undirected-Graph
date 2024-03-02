/***************************************************************/
/* Evelyn Vu                                                   */
/* Login ID: evu                                               */
/* CS 3310, Spring 2024                                        */
/* Programming Assignment 1                                    */
/* Prog1 class: With an undirected graph as input, output      */
/*              the vertices of each connected component       */
/***************************************************************/

import java.io.*;

public class Prog1 {

    public static void main(String[] args) throws Exception {

        // Check input argument
        if(args.length < 1) {
            System.out.println("Usage: java Prog1 <input_file>");
            return;
        }

        // Read input file 
        File file = new File("../input/" + args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int graphNum = 1;
        System.out.println();

        // Iterate through every line of input file
        while((line = br.readLine()) != null) {
            System.out.println("Graph" + graphNum + ":  " + line);
            
            processGraph(line); // Process graph for each line

            graphNum++;
        }

        br.close();
    }

    /**************************************************************/
    /* Method: processGraph                                       */
    /* Purpose: process graph for each line of the input          */
    /* Parameters:                                                */
    /* String line: one line of input file                        */
    /**************************************************************/

    public static void processGraph(String line) {

        // Split the line to parts to decide the number of vertices and the edges
        String[] parts = line.split("\s+");
        int numVertices = Integer.parseInt(parts[0]);

        // Initialize new graph
        Graph graph = new Graph(numVertices);

        graph.addVertex(); // Add vertices to the new graph
        graph.addEdge(parts); // Add edges to the new graph
        graph.connectComponent(); // Create connection between vertices
        graph.printResult(); // Output
    }
}