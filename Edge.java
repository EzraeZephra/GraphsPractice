import java.util.ArrayList;

public class Edge <T extends Comparable<T>>{
    T label;
    Vertex ver1;
    Vertex ver2;

    Edge (T label, Vertex ver1, Vertex ver2) {
        this.label = label;
        this.ver1 = ver1;
        this.ver2 = ver2;
    }

    public ArrayList<Vertex> getVertices() {
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        list.add(ver1);
        list.add(ver2);
        return list;
    }

    public T getData() {
        return label;
    }

}
