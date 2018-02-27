package sfbay;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    private int capacity;

    private int size = 0;

    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map = new HashMap<>();

    private static class ListNode {
        int val;
        int key;
        ListNode prev, next;
    }

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        ListNode n = map.get(key);
        if (n==null) return -1;

        ListNode nprev = n.prev;

        if (n.prev != null) {
            n.prev = n.next;
        }
        if (n.next != null) {
            n.next = n.prev;
        }
        head.prev = n;
        n.next = head;
        head = n;
        head.prev = null;

        if (n==tail) {
            tail=nprev;
        }
        return n.val;
    }

    public void put(int key, int value) {
        size ++;

        if (size - capacity>0) {
            ListNode last = tail;
            tail = last.prev;
            tail.next = null;
            map.remove(last.key);
            size--;
        }

        ListNode n = new ListNode();
        n.val = value;
        n.key = key;

        map.put(key, n);

        if (head==null) {
            head = n;
            tail = n;
        }
        else {
            head.prev = n;
            n.next = head;
            head = n;
        }
    }
    public static void main(String ...s) {
        LRU lru = new LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);

    }
}
