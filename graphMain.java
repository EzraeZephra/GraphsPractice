public class graphMain {
    public static void main(String[] args) {
        graph graph = new graph<>();
        graph.insertVertex(5);
        graph.insertVertex(6);
        System.out.println(graph.numVertices());
        System.out.println(graph.numEdges());
    }
}