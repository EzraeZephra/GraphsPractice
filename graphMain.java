public class graphMain {
    public static void main(String[] args) {
        graph graph = new graph<>();
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertEdge("f", 1, 2);
        graph.insertEdge("a", 1, 3);
        System.out.println(graph.getEdge(1, 3).getData());
        System.out.println(graph.numEdges());
    }
}