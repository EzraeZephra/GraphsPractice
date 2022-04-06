class Vertex<T extends Comparable<T>> {
    T label;
    
    Vertex (T label) {
        this.label = label;
    }

    public T getData() {
        return label;
    }
}