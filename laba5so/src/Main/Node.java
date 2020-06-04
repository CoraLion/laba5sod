package Main;

public class Node<K,V> {
    private Node<K,V> next;
    private Node<K,V> prev;
    private K hash;
    private V data;

    public Node(K hash, V data) {
        this.hash = hash;
        this.data = data;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    public Node<K,V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
