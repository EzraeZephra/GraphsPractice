public class Edge <T extends Comparable<T>>{
    T label;
    Vertex ver1;
    Vertex ver2;

    Edge (T label, Vertex ver1, Vertex ver2) {
        this.label = label;
        this.ver1 = ver1;
        this.ver2 = ver2;
    }

}
