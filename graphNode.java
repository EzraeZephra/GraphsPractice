import java.util.HashMap;
public class graphNode<T extends Comparable<T>> {
    HashMap<Vertex, Edge> map = new HashMap<>();
    Vertex v1;

    graphNode(Vertex v1, HashMap map) {
        this.map = map;
        this.v1 = v1;
    }
    
    public Vertex getVertex() {
        return v1;
    }

    public HashMap getHashMap() {
        return map;
    }
}
