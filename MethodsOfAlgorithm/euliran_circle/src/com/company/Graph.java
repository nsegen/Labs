package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgaponenko on 14.11.16.
 */
public class Graph {

    protected int V;
    protected int E;
    protected List<Edge>[] adjArr;

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Graph(int v, int e) {
        V = v;
        E = e;
    }

    public Graph(Graph g) {
        V = g.getV();
        E = g.getE();
        adjArr =(ArrayList<Edge> []) new ArrayList[g.getV()];
        for (int i = 0; i <g.getV() ; i++) {

            adjArr[i] =new ArrayList<>( g.adj(i) );
        }

    }

    public Graph(int v) {
        V = v;
        E = 0;
        adjArr =(ArrayList<Edge> []) new ArrayList[v];
        for (int i = 0; i <v ; i++) {

            adjArr[i] = new ArrayList<>();
        }

    }

    public void addEdge(int u, int v, int weight) {
        adjArr[u].add( new Edge(u,v,weight));
        adjArr[v].add( new Edge(v,u,weight));
        E++;
    }

    List<Edge> adj(int v) {
        return adjArr[v];
    }



    @Override
    public String toString() {
        String s = "Graph{" +
                "V=" + V +
                ", E=" + E +
                '}'+"\n";
        for (int i = 0; i < V; i++) {
                s+=": \n";
            for (Edge edge :adj(i) ) {
                s+= edge.toString() + " ";
            }
            s+="\n";
        }
        return s;
    }


    public Edge deleteEdge(int v, int u) {

        Edge e = null;
        for (int i = 0; i < adjArr[v].size() ; i++) {
            if (u == adjArr[v].get(i).getV2()) {
                e = adjArr[v].remove(i);
            }
        }
        return e;
    }

    public List<Edge> getAllEdges() {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < getV(); i++) {
            edges.addAll(adj(i));
        }
        return edges;
    }
}
