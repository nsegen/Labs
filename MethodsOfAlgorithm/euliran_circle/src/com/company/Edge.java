package com.company;

/**
 * Created by fgaponenko on 21.11.16.
 */
public class Edge implements Comparable<Edge> {
    private int weight;
    private int v1;
    private int v2;

    public Edge( int v1, int v2,int weight) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.getWeight(),o.getWeight());
    }
}
