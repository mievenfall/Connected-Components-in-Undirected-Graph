/***************************************************************/
/* Evelyn Vu                                                   */
/* Login ID: evu                                               */
/* CS 3310, Spring 2024                                        */
/* Programming Assignment 1                                    */
/* Prompt: For a given undirected graph,                       */
/*         output the vertices of each connected component     */
/*******************************************************s********/

import java.io.*;

public class Prog1 {

    public static void main(String[] args) throws Exception {

        // Check input argument
        if(args.length < 1) {
            System.out.println("Usage: java Prog1 <input_file>");
            return;
        }

        // Read input file 
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int graphNum = 1;
        System.out.println();

        while((line = br.readLine()) != null) {
            System.out.println("Graph" + graphNum + ":  " + line);
            
            String[] parts = line.split("\s+");
            int numVertices = Integer.parseInt(parts[0]);

            Graph graph = new Graph(numVertices);

            graph.addVertex();
            graph.addEdge(parts);
            graph.connectComponent();
            graph.printResult();

            graphNum++;
        }

        br.close();
    }
}