import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class graph<T extends Comparable<T>>{
    /*
    endVertices(e)
    Returns an array containing the two endpoint vertices of edge e. If the graph is directed, the first vertex is the origin and the second is the destination.
    opposite(v, e)
    For edge e incident to vertex v, returns the other vertex of the edge; an error occurs if e is not incident to v.
    outDegree(v)
    Returns the number of outgoing edges from vertex v.
    inDegree(v)
    Returns the number of incoming edges to vertex v. For an undirected graph, this returns the same value as does outDegree(v).
    outgoingEdges(v)
    Returns an iteration of all outgoing edges from vertex v.
    incomingEdges(v)
    Returns an iteration of all incoming edges to vertex v. For an undirected graph, this returns the same collection as does outgoingEdges(v).
    removeVertex(v)
    Removes vertex v and all its incident edges from the graph.
    removeEdge(e)
    Removes edge e from the graph.
    */

    LinkedList<graphNode<T>> list = new LinkedList<graphNode<T>>();
    ArrayList<Edge<T>> exhaustededge = new ArrayList<Edge<T>>();
    String name;

    graph() {
    }

    public void insertVertex(T data) {
        Vertex<T> v1 = new Vertex<T>(data);
        HashMap<Vertex<T>, Edge<T>> map = new HashMap<>();
        graphNode<T> tempNode = new graphNode<>(v1, map);
        list.add(tempNode);
    }

    public Edge<T> insertEdge(T data, T v1, T v2) {
        Edge<T> edge = new Edge<T>(data, new Vertex<T>(v1), new Vertex<T>(v2));
        HashMap<Vertex, Edge> map;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVertex().getData() == v1) {
                map = list.get(i).getHashMap();
                if (map.get(list.get(i).getVertex()) == edge) {
                    return null;
                }
                else {
                    map.put(new Vertex<T>(v1), edge);
                }
            }
            else if (list.get(i).getVertex().getData() == v2) {
                map = list.get(i).getHashMap();
                if (map.get(list.get(i).getVertex()) == edge) {
                    return null;
                }
                else {
                    map.put(new Vertex<T>(v2), edge);
                }
            }
        }
        return edge;
    }

    public int numVertices() {
        return list.size();
    }

    public ArrayList<Vertex<T>> vertices() {
        ArrayList<Vertex<T>> vertices = new ArrayList<Vertex<T>>();
        for (int i = 0; i < list.size(); i++) {
            vertices.add(list.get(i).getVertex());
        }
        return vertices;
    }

    public ArrayList<Edge<T>> edges() {
        ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
        ArrayList<T> edgeValues = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<Vertex<T>, Edge<T>> tempMap = list.get(i).getHashMap();
            for(Vertex<T> vertex: tempMap.keySet()) {
                T value = tempMap.get(vertex).getData();
                if (edges.size() == 0) {
                    edgeValues.add(value);
                    edges.add(tempMap.get(vertex));
                }
                else if (isInList(edgeValues, value) == false) {
                    edgeValues.add(value);
                    edges.add(tempMap.get(vertex));
                }
            }
        }
        return edges;
    }

    public int numEdges() {
        int numEdges = 0;
        ArrayList<T> edges = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<Vertex<T>, Edge<T>> tempMap = list.get(i).getHashMap();
            for(Vertex<T> vertex: tempMap.keySet()) {
                T value = tempMap.get(vertex).getData();
                if (edges.size() == 0) {
                    edges.add(value);
                    numEdges++;
                }
                else if (isInList(edges, value) == false) {
                    edges.add(value);
                    numEdges++;
                }

            }
        }
        return numEdges;
    }

    public Edge<T> getEdge(T v1, T v2) {
        Edge toReturn;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVertex().getData().compareTo(v1) == 0) {
                HashMap<Vertex<T>, Edge<T>> tempMap = list.get(i).getHashMap();
                for(Vertex<T> vertex: tempMap.keySet()) {
                    Edge<T> value = tempMap.get(vertex);
                    for (int j = 0; j < value.getVertices().size(); j++) {
                        if (value.getVertices().get(j).getData().compareTo(v2) == 0) {
                            return value;
                        }
                    }
                }  
            }
            else if (list.get(i).getVertex().getData().compareTo(v2) == 0) {
                HashMap<Vertex<T>, Edge<T>> tempMap = list.get(i).getHashMap();
                for(Vertex<T> vertex: tempMap.keySet()) {
                    Edge<T> value = tempMap.get(vertex);
                    for (int j = 0; j < value.getVertices().size(); j++) {
                        if (value.getVertices().get(j).getData().compareTo(v1) == 0) {
                            return value;
                        }
                    }
                }  
            }
        }
        return null;
    }

    public boolean isInList(ArrayList<T> list, T data) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == data) {
                return true;
            }
        }
        return false;
    }
}
