# Connected Components in Undirected Graph
CS 3310 - Design and Analysis of Algorithms: Program Assignment 1

This program output the vertices of each connected component for a given undirected graph.

## Description
Connected component: in graph theory, a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.

This program takes inputs from a file via the command line with the following structure in the input file. Each line of the input file represents a graph. The first number in a line specifies the number of vertices in the graph. Then pairs of vertices define the edges.
An example of an input file is as follows:
```
5 (1,2) (3,4) (3,5) (4,5)
4 (1,2) (2,3) (1,4)
```
It specifies two graphs. The first graph has five vertices (1,2,3,4,5) and four edges. The second graph has four vertices (1,2,3,4) and three edges.

The output should look (something) like:
```
Graph1:  5 (1,2) (3,4) (3,5) (4,5)
2 connected components: {1 2} {3 4 5}

Graph2:  4 (1,2) (2,3) (1,4)
1 connected component: {1 2 3 4}
```

## Project Hierarchy
```
.
├── input
│   └── SampleInput.txt
├── output
│   └── SampleOutput.txt
├── prompt
│   ├── Prog1 example.pdf
│   ├── grade1.pdf
│   └── prog1.pdf
├── src
│   ├── Graph.java
│   └── Prog1.java
└── .gitignore
```

## Usage
To use the program:

- Add your input file to `/input` folder
- Navigate to the /src directory by `cd src`
- Run `javac Prog1.java` and `java Prog1 <YOUR_INPUT_FILE>` (or `java Prog1 SampleInput.txt` for the sample input file)
- The program will output the connected components of each graph in your input file
