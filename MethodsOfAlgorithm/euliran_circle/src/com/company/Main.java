package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(2,0,23);
        g.addEdge(0,1,3);
        g.addEdge(1,2,243);
        g.addEdge(2,3,243);
        g.addEdge(3,0,243);
        g.addEdge(3,1,243);
        GraphOperations.findEulerCycle(g);

    }
}
