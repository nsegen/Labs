package com.company;

/**
 * Created by fgaponenko on 28.11.16.
 */
public class DirectedGraph extends Graph {
    public DirectedGraph(int v, int e) {
        super(v, e);
    }

    public DirectedGraph(int v) {
        super(v);
    }

    public DirectedGraph(DirectedGraph g) {
        super(g);
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        adjArr[u].add( new Edge(u,v,weight));
        System.out.println(adjArr[u]);
        E++;
    }
}
