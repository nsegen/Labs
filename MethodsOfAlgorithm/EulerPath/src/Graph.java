import java.util.*;

/**
 * Created by nsegen on 21.11.16.
 */
public class Graph {

    private Set<Vertex> graph;
    private int amountVertex;

    public Graph() {

        graph = new HashSet<>();
        amountVertex = 0;

    }

    public int getAmountVertex() {
        return amountVertex;
    }

    public Graph addVertex(Vertex v) {
        graph.add(v);
        amountVertex++;
        return this;
    }

    public Graph removeEdge(Vertex v1, Vertex v2) {

        v1.removeVertex(v2);
        v2.removeVertex(v1);

        return this;

    }

}
