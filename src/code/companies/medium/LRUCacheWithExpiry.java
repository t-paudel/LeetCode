package code.companies.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCacheWithExpiry {
    static void main() throws InterruptedException {
        LRUCacheWithExpiry cache = new LRUCacheWithExpiry(3);
        System.out.println(cache);
        cache.put(1, 100, 5000);
        cache.put(2, 101, 5000);
        cache.put(3, 103, 5000);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        Thread.sleep(6000);
        cache.get(1);
        System.out.println(cache);
    }

    static class Node {
        int key;
        int value;
        long ttl;
        Node prev;
        Node next;

        Node(int key, int value, long ttl) {
            this.key = key;
            this.value = value;
            this.ttl = System.currentTimeMillis() + ttl;
        }
    }

    int capacity;
    Map<Integer, Node> cache;
    PriorityQueue<Node> pq;
    Node head;
    Node tail;

    LRUCacheWithExpiry(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        pq = new PriorityQueue<>(
                Comparator.comparingLong(a -> a.ttl)
        );

        head = new Node(0, 0, 0);
        tail = new Node(0, 0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        cleanUpExpiredKeys();
        if(!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);

        remove(node);
        addNodeToFront(node);

        return node.value;
    }

    public void put(int key, int value, long ttl) {
        cleanUpExpiredKeys();
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.ttl = ttl;

            remove(node);
            addNodeToFront(node);
            pq.offer(node);

            return;
        }

        if(cache.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);

            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value, ttl);
        addNodeToFront(newNode);
        cache.put(key, newNode);
        pq.offer(newNode);
    }

    private void cleanUpExpiredKeys() {
        long now = System.currentTimeMillis();

        while (!pq.isEmpty() &&
                pq.peek().ttl <= now) {

            Node node = pq.poll();

            if (cache.containsKey(node.key)
                    && cache.get(node.key) == node) {

                remove(node);
                cache.remove(node.key);
            }
        }
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
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
        cache.keySet().forEach(key -> {
            sb.append(key).append(" -> ").append(cache.get(key).value).append(", ");
        });
        sb.append("]");

        return sb.toString();
    }
}
