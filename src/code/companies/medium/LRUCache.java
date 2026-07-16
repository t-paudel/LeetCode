package code.companies.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static void main() {

        LRUCache cache = new LRUCache(2);
        System.out.println(cache);
        cache.put(1, 100);
        System.out.println(cache);
        cache.put(2, 101);
        System.out.println(cache);
        cache.put(2, 102);
        System.out.println(cache);
        cache.put(3, 103);
        System.out.println(cache);
    }

    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        removeNode(node);
        addNodeToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            removeNode(node);
            addNodeToFront(node);

            return;
        }

        if(map.size() == capacity) {
            Node lru = tail.prev;
            removeNode(lru);

            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addNodeToFront(newNode);
        map.put(key, newNode);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        map.keySet().forEach(key -> {
            sb.append(key).append(" -> ").append(map.get(key).value).append(", ");
        });
        sb.append("]");

        return sb.toString();
    }
}
