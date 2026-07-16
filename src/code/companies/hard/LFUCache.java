package code.companies.hard;

import java.util.Map;

public class LFU {
    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head;
        Node tail;
        int size;

        DLL() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if(size == 0)
                return null;

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    int capacity;
    int minFreq;

    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;

    
}
