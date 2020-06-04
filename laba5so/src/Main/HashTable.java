package Main;

import java.util.ArrayList;

public class HashTable<K, V> {
    private ArrayList<Node<K,V>> array;
    private int nodenot, fill;

    public HashTable() {
        nodenot = 0;
        fill = 0;
        array = new ArrayList<>(1500000);
        for (int i = 0; i < 1500000; i++) {
            array.add(null);
        }
    }

    public void put(K key, V data) {
        int hkey = convert(key);
        Node<K,V> node = new Node<>(key, data);
        Node<K, V> parent = array.get(hkey);
        if (parent == null) {
            array.set(hkey, node);
            nodenot++;
            fill++;
        } else {
            while (parent.getNext() != null) {
                parent = parent.getNext();
            }
            parent.setNext(node);
            node.setPrev(parent);
            fill++;
        }
    }

    public boolean contains(K key) {
        return array.get(convert(key)) != null;
    }

    private int convert(K key) {
        return Math.abs(key.hashCode())%1500000;
    }
}
