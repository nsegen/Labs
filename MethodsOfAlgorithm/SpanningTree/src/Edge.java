/**
 * Created by nsegen on 3.12.16.
 */
public class Edge {
    public int v1, v2;

    public int weight;

    public Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + v1 + ", " + v2 + ", " + weight + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (v1 != edge.v1) return false;
        if (v2 != edge.v2) return false;
        return weight == edge.weight;

    }

    @Override
    public int hashCode() {
        int result = v1;
        result = 31 * result + v2;
        result = 31 * result + weight;
        return result;
    }
}
