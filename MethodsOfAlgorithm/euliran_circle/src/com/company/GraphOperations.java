package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fgaponenko on 28.11.16.
 */
public class GraphOperations {

    private static DirectedGraph directedGraph;
   private static Stack<Integer> vertexStack;

   private static boolean[] marked;
   private static int[] edgeTo;
   private static boolean[] onStack;
   private static Stack<Integer> cycle;
   private static Edge startE;

    public static void findEulerCycle(DirectedGraph g) {

        if(null == g.adj(0).get(0)) {
            System.out.println("you shall not pass");
            throw new RuntimeException();
        }
        directedGraph = g;
        vertexStack = new Stack<>();
        findEulerPath(0,new Graph(directedGraph));
        while (!vertexStack.empty()) {
            System.out.print(vertexStack.pop() + ", ");
        }
    }

    private static void findEulerPath(int v,Graph g) {
        for (int i = 0; i < g.adj(v).size(); i++) {
           Edge e = g.deleteEdge(v,g.adj(v).get(i).getV2());
            findEulerPath(e.getV2(),g);
        }
        vertexStack.push(v);
    }

}
