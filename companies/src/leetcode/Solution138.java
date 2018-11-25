package leetcode;
import java.util.*;

public class Solution138 {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode copied = copyRandomList(head);
        copied.next = new RandomListNode(2);
        System.out.println(head.label);
        System.out.println(head.next);
        System.out.println(copied.label);
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            RandomListNode copied = map.get(head);
            if (head.next != null) {
                RandomListNode next = head.next;
                if (!map.containsKey(next)) {
                    map.put(next, new RandomListNode(next.label));
                }
                copied.next = map.get(next);
            }

            if (head.random != null) {
                RandomListNode random = head.random;
                if (!map.containsKey(random)) {
                    map.put(random, new RandomListNode(random.label));
                }
                copied.next = map.get(random);
            }
            head = head.next;
        }
        return map.get(dummy.next);
    }
}
