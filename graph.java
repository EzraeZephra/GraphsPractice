import java.util.HashMap;
import java.util.LinkedList;

public class graph<T extends Comparable<T>>{
    LinkedList<graphNode> list = new LinkedList<graphNode>();
    String name;

    graph() {
    }

    public void insertVertex(T data) {
        Vertex v1 = new Vertex(data);
        HashMap<Vertex, Edge> map = new HashMap<>();
        graphNode tempNode = new graphNode<>(v1, map);
        list.add(tempNode);
    }

    public int numVertices() {
        return list.size();
    }

    public int numEdges() {
        int numEdges = 0;
        for (graphNode<T> node : list) {
            HashMap<Vertex, Edge> map = node.getHashMap();
            for(Vertex key: map.keySet()) {
                numEdges++;
            }
        }
        return numEdges;
    }
}
