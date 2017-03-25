import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Uber {
    public class LRUCache {
        private class DLLNode {
            int key, val;
            DLLNode prev, next;
            DLLNode(int k, int v) {
                key = k;
                val = v;
                prev = null;
                next = null;
            }
        }
        private Map<Integer, DLLNode> map;
        DLLNode head, tail;
        int size;
        
        public LRUCache(int capacity) {
            map = new HashMap<Integer, DLLNode>();
            // two dummy nodes
            // very very important for this problem
            // can save a lot of time to consider null pointer.
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
            size = capacity;
        }
        
        public int get(int key) {
            DLLNode node = map.get(key);
            if (node != null) {
                removeNode(node);
                moveToRear(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            DLLNode node = map.get(key);
            // if the key is already in the memory,
            // update the value and move it to rear.
            if (node != null) {
                node.val = value;
                removeNode(node);
                moveToRear(node);
            } else {
                if (map.size() >= size) {
                    DLLNode front = head.next;
                    removeNode(front);
                    map.remove(front.key);
                }
                node = new DLLNode(key, value);
                moveToRear(node);
                map.put(key, node);
            }
        }
        private void moveToRear(DLLNode node) {
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
        }
        private void removeNode(DLLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Uber u = new Uber();
        
         RandomizedCollection obj = u.new RandomizedCollection();
         obj.insert(0);
         obj.insert(1);
         obj.remove(0);
         obj.insert(2);
         obj.remove(1);
         System.out.println(obj.getRandom());
         
//        RandomizedSet obj = u.new RandomizedSet();
//        obj.insert(1);
//        obj.insert(10);
//        obj.insert(20);
//        obj.insert(30);
//        System.out.println(obj.getRandom());
        
//        LRUCache cache = u.new LRUCache(1);
//        cache.put(2, 1);
//        System.out.println(cache.get(2));       // 1
//        cache.put(3, 2);
//        System.out.println(cache.get(2));       // -1
//        System.out.println(cache.get(3));       // 2
        
        
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // return 1
//        cache.put(3, 3);
//        System.out.println(cache.get(2));       // return -1
//        cache.put(4, 4);
//        System.out.println(cache.get(1));       // return 1
//        System.out.println(cache.get(3));       // return 3
//        System.out.println(cache.get(4));       // return 4
        
        
//        System.out.println(cache.get(2));      // return -1
//        cache.put(2, 6);
//
//        System.out.println(cache.get(1));      // returns -1
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));       // returns 2
//        System.out.println(cache.get(2));       // returns 6
    }
    public class RandomizedSet {

        Set<Integer> set;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            set = new HashSet<Integer>();
        }
        
        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            return set.add(val);
        }
        
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            return set.remove(val);
        }
        
        /** Get a random element from the set. */
        public int getRandom() {
            return set.iterator().next();
        }
    }
    public class RandomizedCollection {

        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<Integer, Set<Integer>>();
            list = new ArrayList<Integer>();
        }
        
        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = true;
            if (!map.containsKey(val)) {
                contain = false;
                map.put(val, new HashSet<Integer>());
            }
            map.get(val).add(list.size());
            list.add(val);
            return !contain;
        }
        
        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            Set<Integer> indexSet = map.get(val);
            if (indexSet == null) {
                return false;
            }
            int index = indexSet.iterator().next();
            indexSet.remove(index);
            if (indexSet.size() == 0) {
                map.remove(val);
            }
            if (index < list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                Set<Integer> lastSet = map.get(lastVal);
                lastSet.remove(list.size() - 1);
                lastSet.add(index);
            }
            list.remove(list.size() - 1);
            return true;
        }
        
        /** Get a random element from the collection. */
        public int getRandom() {
            Random randGen = new Random();
            int rand = randGen.nextInt(list.size());
            return list.get(rand);
        }
    }
}
