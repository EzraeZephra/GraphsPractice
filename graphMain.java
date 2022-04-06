import java.util.ArrayList;

public class graphMain {
    public static void main(String[] args) {
        graph graph = new graph<>();
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertEdge("f", 1, 2);
        graph.insertEdge("a", 1, 3);
        /*System.out.println(graph.opposite(1, "a").getData());
        System.out.println(graph.getEdge(2, 1).getData());
        System.out.println(graph.numEdges());
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        list = graph.endVertices("a");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getData());
        }*/

    }
}