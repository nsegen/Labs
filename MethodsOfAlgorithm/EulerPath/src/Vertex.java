import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by nsegen on 21.11.16.
 */
public class Vertex {

    private String name;
    private Set<Vertex> incidentVertexes;
    private int power;

    public Vertex(String name, Set<Vertex> vertexes) {

        incidentVertexes = vertexes;
        this.name = name;
        power = incidentVertexes.size();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getIncidentVertexes() {
        return new ArrayList<>(incidentVertexes);
    }

    public void setIncidentVertexes(Set<Vertex> incidentVertexes) {
        this.incidentVertexes = incidentVertexes;
        power = incidentVertexes.size();
    }

    public int getPower() {
        return power;
    }

    public boolean removeVertex(Vertex v) {

        return incidentVertexes.remove(v);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return getPower() == vertex.getPower() &&
                Objects.equals(getName(), vertex.getName()) &&
                Objects.equals(getIncidentVertexes(), vertex.getIncidentVertexes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIncidentVertexes(), getPower());
    }
}
